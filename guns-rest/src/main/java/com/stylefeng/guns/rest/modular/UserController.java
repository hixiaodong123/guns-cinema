package com.stylefeng.guns.rest.modular;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: jia.xue
 * @create: 2019-08-28 10:16
 * @Description
 **/
@RestController
public class UserController {

    @RequestMapping("/test")
    public String test(){
        return "hello";
    }
}