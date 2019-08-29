package com.stylefeng.guns.rest.modular.user;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.order.OrderServiceAPI;
import com.stylefeng.guns.api.user.UserServerAPI;
import com.stylefeng.guns.api.user.vo.UserRegisterModel;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
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

    @Reference(interfaceClass = UserServerAPI.class)
    private UserServerAPI userServerAPI;

    @Reference(interfaceClass = OrderServiceAPI.class)
    private OrderServiceAPI orderServiceAPI;

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
            boolean success = userServerAPI.register(userRegisterModel);
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
            boolean flag = userServerAPI.checkUsername(username);
            if (flag)
            {
                //用户不存在
                return ResponseVO.success("验证成功,用户名不存在!");
            }
            else {
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

}


