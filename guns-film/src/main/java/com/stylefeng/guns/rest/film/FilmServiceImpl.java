package com.stylefeng.guns.rest.film;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.api.film.FilmServiceAPI;
import com.stylefeng.guns.api.film.bean.*;
import com.stylefeng.guns.rest.common.persistence.dao.*;
import com.stylefeng.guns.rest.common.persistence.model.*;
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
    @Autowired
    CatDictTMapper catDictTMapper;
    @Autowired
    YearDictTMapper yearDictTMapper;
    @Autowired
    SourceDictTMapper sourceDictTMapper;
    @Override
    public List<BannerVo> getBanners() {
        List<BannerT> list=bannerTMapper.selectList(null);
        List<BannerVo> voList=new ArrayList<>();
        for (BannerT bannerT : list) {
            BannerVo bannerVo=new BannerVo();
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
        for (FilmT filmT : filmTS) {
            VoFilmInfo filmVo = new VoFilmInfo();
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
        wrapper.orderBy("film_score").last("limit 100");
        List<FilmT> filmTS=filmTMapper.selectList(wrapper);
        List<VoFilmInfo> list=new ArrayList<>();
        for (FilmT filmT : filmTS) {
            VoFilmInfo filmVo = new VoFilmInfo();
            filmVo.setFilmId(filmT.getUuid());
            filmVo.setImgAddress(filmT.getImgAddress());
            filmVo.setFilmName(filmT.getFilmName());
            filmVo.setScore(Double.parseDouble(filmT.getFilmScore()));
            list.add(filmVo);
        }
        return list;
    }

    @Override
    public List<VoFilmInfo> getBoxRnking() {
        EntityWrapper wrapper=new EntityWrapper();
        wrapper.orderBy("film_box_office");
        List<FilmT> filmTS=filmTMapper.selectList(wrapper);
        List<VoFilmInfo> list=new ArrayList<>();
        for (FilmT filmT : filmTS) {
            VoFilmInfo voFilmInfo = new VoFilmInfo();
            voFilmInfo.setBoxNum(filmT.getFilmBoxOffice());
            voFilmInfo.setExpectNum(filmT.getUuid());
            voFilmInfo.setFilmName(filmT.getFilmName());
            voFilmInfo.setImgAddress(filmT.getImgAddress());
            list.add(voFilmInfo);
        }
        return list;
    }

    @Override
    public FilmVo getHotFilms() {
        EntityWrapper wrapper=new EntityWrapper();
        wrapper.eq("film_status",1);
        List<FilmT> filmTS=filmTMapper.selectList(wrapper);
        Long filmNum= Long.valueOf(filmTMapper.selectCount(wrapper));
        List<VoFilmInfo> list=new ArrayList<>();
        for (FilmT filmT : filmTS) {
            VoFilmInfo voFilmInfo = new VoFilmInfo();
            voFilmInfo.setFilmId(filmT.getUuid());
            voFilmInfo.setFilmType(filmT.getFilmType());
            voFilmInfo.setImgAddress(filmT.getImgAddress());
            voFilmInfo.setFilmName(filmT.getFilmName());
            voFilmInfo.setScore(Double.parseDouble(filmT.getFilmScore()));
            list.add(voFilmInfo);
        }
        FilmVo filmVo=new FilmVo();
        filmVo.setFilmInfo(list);
        filmVo.setFilmNum(filmNum);
        return filmVo;
    }

    @Override
    public FilmVo getSoonFilms() {
        EntityWrapper wrapper=new EntityWrapper();
        wrapper.eq("film_status",2);
        List<FilmT> filmTS=filmTMapper.selectList(wrapper);
        Long filmNum= Long.valueOf(filmTMapper.selectCount(wrapper));
        List<VoFilmInfo> list=new ArrayList<>();
        for (FilmT filmT : filmTS) {
            VoFilmInfo voFilmInfo = new VoFilmInfo();
            voFilmInfo.setFilmId(filmT.getUuid());
            voFilmInfo.setFilmType(filmT.getFilmType());
            voFilmInfo.setImgAddress(filmT.getImgAddress());
            voFilmInfo.setFilmName(filmT.getFilmName());
            voFilmInfo.setExpectNum(filmT.getFilmPresalenum());
            voFilmInfo.setShowTime(filmT.getFilmTime());
            list.add(voFilmInfo);
        }
        FilmVo filmVo=new FilmVo();
        filmVo.setFilmInfo(list);
        filmVo.setFilmNum(filmNum);
        return filmVo;
    }

    @Override
    public List<CatInfo> getCat(Integer catId) {
        List<CatDictT> catDictTS=catDictTMapper.selectList(null);
        List<CatInfo> catInfos=new ArrayList<>();
        for (CatDictT t : catDictTS) {
            CatInfo catInfo = new CatInfo();
            catInfo.setCatId(t.getUuid());
            catInfo.setCatName(t.getShowName());
            if(catInfo.getCatId()==catId){
                catInfo.setIsActive(true);
            }
            catInfos.add(catInfo);
        }
        return catInfos;
    }

    @Override
    public List<YearInfo> getYear(Integer yearId) {
        List<YearDictT> catDictTS=yearDictTMapper.selectList(null);
        List<YearInfo> catInfos=new ArrayList<>();
        for (YearDictT t : catDictTS) {
            YearInfo catInfo = new YearInfo();
            catInfo.setYearId(t.getUuid());
            catInfo.setYearName(t.getShowName());
            if(catInfo.getYearId()==yearId){
                catInfo.setIsActive(true);
            }
            catInfos.add(catInfo);
        }
        return catInfos;
    }

    @Override
    public List<SourceInfo> getSource(Integer sourceId) {
        List<SourceDictT> catDictTS=sourceDictTMapper.selectList(null);
        List<SourceInfo> catInfos=new ArrayList<>();
        for (SourceDictT t : catDictTS) {
            SourceInfo catInfo = new SourceInfo();
            catInfo.setSourceId(t.getUuid());
            catInfo.setSourceName(t.getShowName());
            if(catInfo.getSourceId()==sourceId){
                catInfo.setIsActive(true);
            }
            catInfos.add(catInfo);
        }
        return catInfos;
    }
}
