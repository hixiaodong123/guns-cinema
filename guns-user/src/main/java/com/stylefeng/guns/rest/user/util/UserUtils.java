package com.stylefeng.guns.rest.user.util;

import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * @description: 用户模块用到的工具类
 * @author: Lime
 * @create: 2019-08-30 10:32
 **/

public class UserUtils
{
    private UserUtils()
    {
    }

    public static UserInfoModel mtimeUserT2UserInfoModel(MtimeUserT mtimeUserT)
    {

        /**
         * 该对象是数据库获取的,由于我们都设置了数据库字段的初始值,所以不用担心空指针
         */

        //将数据对象转换成UserInfoModel对象,并且返回这个对象即可
        return new UserInfoModel(mtimeUserT.getUuid(), mtimeUserT.getUserName(), mtimeUserT.getNickName(), mtimeUserT.getEmail(), mtimeUserT.getUserPhone(), mtimeUserT.getUserSex(), mtimeUserT.getBirthday(), "" + mtimeUserT.getLifeState(), mtimeUserT.getBiography(), mtimeUserT.getAddress(), mtimeUserT.getHeadUrl(), mtimeUserT.getBeginTime().getTime(), mtimeUserT.getUpdateTime().getTime());
    }

    public static MtimeUserT userInfoModel2MtimeUserT(UserInfoModel userInfoModel)
    {

        /**
         * 该对象是从前端获取的,我们无法控制是否为空,所以使用BeanUtils工具类,无法自动填充的,
         *      也要先判空再赋值,避免空指针异常
         */

        //将数据对象转换成UserInfoModel对象,并且返回这个对象即可
        MtimeUserT mtimeUserT = new MtimeUserT();
        BeanUtils.copyProperties(userInfoModel, mtimeUserT);
        if (userInfoModel.getSex()!=null)
        {
            //性别不为空,修改它
            mtimeUserT.setUserSex(userInfoModel.getSex());
        }
        if (userInfoModel.getLifeState()!=null)
        {
            //状态不为空,修改它
            mtimeUserT.setLifeState(Integer.parseInt(userInfoModel.getLifeState()));
        }
        //if (userInfoModel.getNickname()!=null)
        //{
            //昵称不为空,修改它
            mtimeUserT.setNickName(userInfoModel.getNickname());
        //}
        if (userInfoModel.getPhone()!=null)
        {
            //手机号不为空,修改它
            mtimeUserT.setUserPhone(userInfoModel.getPhone());
        }

        //修改时间设置为当前时间
        mtimeUserT.setUpdateTime(new Date());
        return mtimeUserT;

    }


}
