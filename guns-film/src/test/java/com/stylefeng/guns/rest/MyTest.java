package com.stylefeng.guns.rest;

import com.stylefeng.guns.rest.common.persistence.dao.BannerTMapper;
import com.stylefeng.guns.rest.common.persistence.model.BannerT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FilmApplication.class)
public class MyTest {
    @Autowired
    BannerTMapper bannerTMapper;
    @Test
    public void test(){
        List<BannerT> bannerT=bannerTMapper.queryAll();
        System.out.println(bannerT);
    }
}
