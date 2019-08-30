package com.stylefeng.guns.api.user;

import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.api.user.vo.UserRegisterModel;

/**
 * @description:
 * @author: Lime
 * @create: 2019-08-29 11:58
 **/

public interface UserServiceAPI
{
    //登录方法,返回user的id
    int login(String username, String password);

    //注册
    boolean register(UserRegisterModel userRegisterModel);

    //验证用户名
    boolean checkUsername(String username);

    //获取用户信息
    UserInfoModel getUserInfo(int uuid);

    //更新用户信息
    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);


}
