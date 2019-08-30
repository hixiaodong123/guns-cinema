package com.stylefeng.guns.rest.user;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.user.UserServiceAPI;
import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.api.user.vo.UserRegisterModel;
import com.stylefeng.guns.rest.common.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.rest.user.util.UserUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.util.Date;


/**
 * @description: 用户模块具体业务实现
 * @author: Lime
 * @create: 2019-08-29 14:07
 **/


@Component
@Service(interfaceClass = UserServiceAPI.class)
public class UserServiceImpl implements UserServiceAPI
{
    @Autowired
    private MtimeUserTMapper mtimeUserTMapper;

    @Override
    public int login(String username, String password)
    {

        //根据登录的账户查询数据库对应的加密后的密码
        MtimeUserT selectOne = mtimeUserTMapper.selectOne(new MtimeUserT(username));
        if (selectOne != null && selectOne.getUuid() > 0)
        {
            String dataBasePass = selectOne.getUserPwd(); //数据库中的密码
            //根据username和password加密获取的密码然后比对
            String loginPass = new SimpleHash("MD5", password, username, 2).toHex();
            if (loginPass.equals(dataBasePass))
            {
                //说明登录成功
                return selectOne.getUuid();
            }

        }
        return 0;
    }

    @Override
    public boolean register(UserRegisterModel userRegisterModel)
    {
        //先判断要注册的用户名是否存在
        String username = userRegisterModel.getUsername();
        MtimeUserT select = new MtimeUserT(username);
        MtimeUserT dataObj = mtimeUserTMapper.selectOne(select);
        if (dataObj != null)
        {
            //说明用户名已经存在
            return false;
        }
        //将获取的注册的信息的实体转换成用户的实体

        MtimeUserT mtimeUserT = new MtimeUserT();
        mtimeUserT.setUserName(userRegisterModel.getUsername());
        mtimeUserT.setAddress(userRegisterModel.getAddress());
        mtimeUserT.setEmail(userRegisterModel.getEmail());
        mtimeUserT.setUserPhone(userRegisterModel.getPhone());

        //密码要经过加密处理
        String password = userRegisterModel.getPassword();
        password = new SimpleHash("MD5", password, userRegisterModel.getUsername(), 2).toHex();
        mtimeUserT.setUserPwd(password);

        //注册时间和更新时间直接置位当前时间
        Date date = new Date();
        mtimeUserT.setBeginTime(date);
        mtimeUserT.setUpdateTime(date);

        //将两个int类型赋值
        //生活状态-4-前端不显示
        //性别-2-前端不显示
        mtimeUserT.setLifeState(4);
        mtimeUserT.setUserSex(2);

        //存入数据库
        try
        {
            mtimeUserTMapper.insert(mtimeUserT);
            //注册成功
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException("系统异常!");
        }
    }

    @Override
    public boolean checkUsername(String username)
    {

        EntityWrapper<MtimeUserT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name", username);
        Integer resultCount = mtimeUserTMapper.selectCount(entityWrapper);
        if (resultCount != null && resultCount == 1)
        {
            //说明该用户名存在
            return false;
        }
        else
        {
            //用户不存在
            return true;
        }
    }


    @Override
    public UserInfoModel getUserInfo(int uuid)
    {
        //通过获取的UUID查询出对应的数据库对象MtimeUserT
        MtimeUserT mtimeUserT = mtimeUserTMapper.selectById(uuid);
        //将数据对象转换成UserInfoModel对象,并且返回这个对象即可
        return UserUtils.mtimeUserT2UserInfoModel(mtimeUserT);
    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel)
    {

        //将从前端获取的userInfoModel对象转换成数据库中的mtimeUserT对象
        MtimeUserT mtimeUserT = UserUtils.userInfoModel2MtimeUserT(userInfoModel);
        //更新
        Integer integer = mtimeUserTMapper.updateById(mtimeUserT);

        if (integer > 0)
        {
            //说明更新成功了
            //通过id将更新后的用户信息查出来
            return getUserInfo(mtimeUserT.getUuid());
        }
        else
        {
            //说明更新未成功
            //将未更新的用户信息返回去
            return userInfoModel;
        }
    }
}

