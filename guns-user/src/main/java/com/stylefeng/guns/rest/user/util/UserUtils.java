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
        //将数据对象转换成UserInfoModel对象,并且返回这个对象即可
        return new UserInfoModel(mtimeUserT.getUuid(), mtimeUserT.getUserName(), mtimeUserT.getNickName(), mtimeUserT.getEmail(), mtimeUserT.getUserPhone(), mtimeUserT.getUserSex(), mtimeUserT.getBirthday(), "" + mtimeUserT.getLifeState(), mtimeUserT.getBiography(), mtimeUserT.getAddress(), mtimeUserT.getHeadUrl(), mtimeUserT.getBeginTime().getTime(), mtimeUserT.getUpdateTime().getTime());
        //UserInfoModel userInfoModel = new UserInfoModel();
        //BeanUtils.copyProperties(mtimeUserT, userInfoModel);
        //return userInfoModel;
    }

    public static MtimeUserT userInfoModel2MtimeUserT(UserInfoModel userInfoModel)
    {
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
        if (userInfoModel.getNickname()!=null)
        {
            //昵称不为空,修改它
            mtimeUserT.setNickName(userInfoModel.getNickname());
        }
        if (userInfoModel.getPhone()!=null)
        {
            //手机号不为空,修改它
            mtimeUserT.setUserPhone(userInfoModel.getPhone());
        }

        //修改时间设置为当前时间
        mtimeUserT.setUpdateTime(new Date());
        return mtimeUserT;
        //return new MtimeUserT(userInfoModel.getUuid(), userInfoModel.getUsername(), userInfoModel.getNickname(), userInfoModel.getSex(), userInfoModel.getBirthday(), userInfoModel.getEmail(), userInfoModel.getPhone(), userInfoModel.getAddress(), userInfoModel.getHeadAddress(), userInfoModel.getBiography(), Integer.parseInt(userInfoModel.getLifeState()), getDate(userInfoModel.getBeginTime()), getDate(userInfoModel.getUpdateTime()));
    }

    private static Date getDate(long time)
    {
        return new Date(time);
    }

}
