package com.stylefeng.guns.rest.modular;


import com.stylefeng.guns.rest.common.persistence.model.MtimeUserT;
import com.stylefeng.guns.rest.common.persistence.service.IMtimeUserTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author stylefeng
 * @since 2019-08-28
 */
@RestController
@RequestMapping("/mtime")
public class MtimeUserTController {

    @Autowired
    private IMtimeUserTService mtimeUserTService;

    @RequestMapping("getUserById")
    public MtimeUserT getUserById(Integer userId){
        MtimeUserT mtimeUserT = mtimeUserTService.selectById(userId);
        return mtimeUserT;
    }

    @RequestMapping("getUserByName")
    public MtimeUserT getUserById(String  username){
        MtimeUserT mtimeUserT = mtimeUserTService.getUserInfoByUserName(username);
        return mtimeUserT;
    }

}

