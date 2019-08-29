package com.stylefeng.guns.rest.cinema;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.cinema.CinemaServiceAPI;
import org.springframework.stereotype.Component;

/**
 * @description: 影院业务实现
 * @author: Lime
 * @create: 2019-08-29 22:38
 **/

@Component
@Service(interfaceClass = CinemaServiceAPI.class)
public class CinemaServiceImpl implements CinemaServiceAPI
{
}
