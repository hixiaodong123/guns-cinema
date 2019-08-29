package com.stylefeng.guns.rest.film;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.film.FilmServiceAPI;
import org.springframework.stereotype.Component;

/**
 * @description: 影片业务实现
 * @author: Lime
 * @create: 2019-08-29 22:01
 **/

@Component
@Service(interfaceClass = FilmServiceAPI.class)
public class FilmServiceImpl implements FilmServiceAPI
{
}
