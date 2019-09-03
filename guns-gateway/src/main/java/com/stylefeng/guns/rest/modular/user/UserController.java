package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.UserServiceAPI;
import com.stylefeng.guns.api.user.vo.UserInfoModel;
import com.stylefeng.guns.api.user.vo.UserRegisterModel;
import com.stylefeng.guns.rest.common.CurrentUser;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: user模块控制器
 * @author: Lime
 * @create: 2019-08-29 16:39
 **/

@RestController
@RequestMapping("/user")
public class UserController
{

    @Reference(interfaceClass = UserServiceAPI.class,check = false)
    private UserServiceAPI userServiceAPI;

    @PostMapping("/register")
    public ResponseVO register(UserRegisterModel userRegisterModel)
    {

        if (userRegisterModel.getUsername() == null || userRegisterModel.getUsername().trim().length() == 0)
        {
            return ResponseVO.serviceFail("用户名不能为空!");
        }
        if (userRegisterModel.getPassword() == null || userRegisterModel.getPassword().trim().length() == 0)
        {
            return ResponseVO.serviceFail("密码不能为空!");
        }

        //开始注册
        try
        {
            boolean success = userServiceAPI.register(userRegisterModel);
            if (success)
            {
                //注册成功
                return ResponseVO.success("注册成功!");
            }
            else
            {
                //说明用户名存在
                return ResponseVO.serviceFail("用户名已存在!");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            return ResponseVO.systemFail("系统异常,请联系管理员!");
        }

    }

    @PostMapping("/check")
    public ResponseVO check(String username)
    {

        //业务实现中写的是:当用户名不存在时返回true
        if (username != null && username.trim().length() > 0)
        {
            //不为空,判断
            boolean flag = userServiceAPI.checkUsername(username);
            if (flag)
            {
                //用户不存在
                return ResponseVO.success("验证成功,用户名不存在!");
            }
            else
            {
                //用户名存在
                return ResponseVO.serviceFail("用户名已存在!");
            }

        }
        else
        {
            //不能传入空参数
            return ResponseVO.serviceFail("用户名不能为空!");

        }
    }

    @GetMapping("/logout")
    public ResponseVO logout()
    {
        return ResponseVO.success("成功退出!");
    }

    @GetMapping("/getUserInfo")
    public ResponseVO getUserInfo()
    {
        //获取当前登录用户的userId
        String userId = CurrentUser.getUserId();
        if (userId != null && userId.trim().length() > 0)
        {
            //能够获取id,说明已登录
            //根据当前登录对象的userId调用service方法
            UserInfoModel userInfo = null;
            try
            {
                userInfo = userServiceAPI.getUserInfo(Integer.parseInt(userId));
                return ResponseVO.success(userInfo);
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return ResponseVO.systemFail("系统异常,请联系管理员");
            }
        }
        else
        {
            //未登录,提醒用户登录
            return ResponseVO.serviceFail("查询失败,用户未登录!");
        }
    }

    @PostMapping("/updateUserInfo")
    public ResponseVO updateUserInfo(UserInfoModel userInfoModel)
    {
        //获取当前登录用户的userId
        String userId = CurrentUser.getUserId();
        if (userId != null && userId.trim().length() > 0)
        {
            //能够获取id,说明已登录
            int loginId = Integer.parseInt(userId);
            //判断登录的id是否是要修改用户信息的id
            if (loginId == userInfoModel.getUuid())
            {
                //能够修改用户信息
                UserInfoModel updateUserInfo = null;
                try
                {
                    updateUserInfo = userServiceAPI.updateUserInfo(userInfoModel);
                    if (updateUserInfo != null)
                    {
                        //说明修改成功了!
                        return ResponseVO.success(updateUserInfo);
                    }
                    else
                    {
                        //说明修改失败了
                        return ResponseVO.serviceFail("修改用户信息失败了!");
                    }
                }
                catch (Exception e)
                {
                    //出错了
                    e.printStackTrace();
                    return ResponseVO.systemFail("系统系统,请联系管理员!");
                }
            }
            else
            {
                //无法修改别人的用户信息
                return ResponseVO.serviceFail("您不能修改别人的信息!");
            }
        }
        else
        {
            //未登录,提醒用户登录
            return ResponseVO.serviceFail("用户未登录!");
        }
    }


}


