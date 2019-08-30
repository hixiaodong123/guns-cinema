package com.stylefeng.guns.rest.film;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.api.film.FilmServiceAPI;
import com.stylefeng.guns.api.film.bean.BannerVo;
import com.stylefeng.guns.api.film.bean.FilmVo;
import com.stylefeng.guns.api.film.bean.VoFilmInfo;
import com.stylefeng.guns.rest.common.persistence.dao.BannerTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.FilmTMapper;
import com.stylefeng.guns.rest.common.persistence.model.BannerT;
import com.stylefeng.guns.rest.common.persistence.model.FilmT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 影片业务实现
 * @author: Lime
 * @create: 2019-08-29 22:01
 **/

@Component
@Service(interfaceClass = FilmServiceAPI.class)
public class FilmServiceImpl implements FilmServiceAPI
{
    @Autowired
    BannerTMapper bannerTMapper;
    @Autowired
    FilmTMapper filmTMapper;
    @Override
    public List<BannerVo> getBanners() {
        List<BannerT> list=bannerTMapper.selectList(null);
        List<BannerVo> voList=new ArrayList<>();
        BannerVo bannerVo=new BannerVo();
        for (BannerT bannerT : list) {
            bannerVo.setBannerId(bannerT.getUuid());
            bannerVo.setBannerAddress(bannerT.getBannerAddress());
            bannerVo.setBannerUrl(bannerT.getBannerUrl());
            voList.add(bannerVo);
        }
        return voList;
    }

    @Override
    public List<VoFilmInfo> getExpectRanking() {
        EntityWrapper wrapper=new EntityWrapper();
        wrapper.orderBy("film_preSaleNum");
        List<VoFilmInfo> list=new ArrayList<>();
        List<FilmT> filmTS=filmTMapper.selectList(wrapper);
        VoFilmInfo filmVo = new VoFilmInfo();
        for (FilmT filmT : filmTS) {
            filmVo.setFilmId(filmT.getUuid());
            filmVo.setImgAddress(filmT.getImgAddress());
            filmVo.setFilmName(filmT.getFilmName());
            filmVo.setExpectNum(filmT.getFilmPresalenum());
            list.add(filmVo);
        }
        return list;
    }

    @Override
    public List<VoFilmInfo> getTop100() {
        EntityWrapper wrapper=new EntityWrapper();
        return null;
    }

    @Override
    public List<VoFilmInfo> getBoxRnking() {
        return null;
    }

    @Override
    public List<FilmVo> getHotFilms() {
        return null;
    }

    @Override
    public List<FilmVo> getSoonFilms() {
        return null;
    }
}
