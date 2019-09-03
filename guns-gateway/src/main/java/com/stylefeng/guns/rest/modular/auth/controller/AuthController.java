package com.stylefeng.guns.rest.modular.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.user.UserServiceAPI;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthResponse;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController
{

    @Reference(interfaceClass = UserServiceAPI.class,check = false)
    private UserServiceAPI userServiceAPI;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping(value = "${jwt.auth-path}")
    public ResponseVO createAuthenticationToken(AuthRequest authRequest)
    {

        boolean validate = true;
        String userName = authRequest.getUserName();
        String password = authRequest.getPassword();


        //判空
        if (userName == null || userName.trim().length() == 0)
        {
            return ResponseVO.serviceFail("用户名不能为空!");
        }
        if (password == null || password.trim().length() == 0)
        {
            return ResponseVO.serviceFail("密码不能为空!");
        }


        //自定义密码验证机制
        int userId = userServiceAPI.login(authRequest.getUserName(), authRequest.getPassword());

        if (userId == 0)
        {
            //验证不通过
            validate = false;
        }

        if (validate)
        {
            //randomKey和token生成完毕
            final String randomKey = jwtTokenUtil.getRandomKey();
            //让token中携带userId,便于后续校验
            final String token = jwtTokenUtil.generateToken("" + userId, randomKey);
            //返回值
            //根据API文档编写
            return ResponseVO.success(new AuthResponse(token, randomKey));
            //return ResponseEntity.ok(new AuthResponse(token, randomKey));
        }
        else
        {
            //失败时业务异常
            return ResponseVO.serviceFail("用户名或者密码错误");
            //throw new GunsException(BizExceptionEnum.AUTH_REQUEST_ERROR);
        }
    }
}
