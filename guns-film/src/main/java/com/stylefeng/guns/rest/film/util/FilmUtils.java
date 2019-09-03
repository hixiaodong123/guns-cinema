package com.stylefeng.guns.rest.film.util;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.film.vo.film.CatInfoVO;
import com.stylefeng.guns.api.film.vo.film.SourceInfoVO;
import com.stylefeng.guns.api.film.vo.film.YearInfoVO;
import com.stylefeng.guns.api.film.vo.index.FilmInfoVO;
import com.stylefeng.guns.api.film.vo.index.FilmVO;
import com.stylefeng.guns.core.util.DateUtil;
import com.stylefeng.guns.rest.common.persistence.dao.FilmInfoTMapper;
import com.stylefeng.guns.rest.common.persistence.dao.FilmTMapper;
import com.stylefeng.guns.rest.common.persistence.model.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;

import java.util.List;

/**
 * @description: 影片工具类
 * @author: Lime
 * @create: 2019-08-30 20:47
 **/

public class FilmUtils
{
    private FilmUtils()
    {
    }


    //  =============首页=========================
    public static FilmInfoVO filmT2FilmInfoVOInHotFilms(FilmT filmT)
    {

        FilmInfoVO filmInfoVO = new FilmInfoVO();
        filmInfoVO.setFilmId("" + filmT.getUuid());
        filmInfoVO.setFilmType(filmT.getFilmType());
        filmInfoVO.setImgAddress(filmT.getImgAddress());
        filmInfoVO.setFilmName(filmT.getFilmName());
        filmInfoVO.setFilmScore(filmT.getFilmScore());

        return filmInfoVO;

    }

    public static FilmInfoVO filmT2FilmInfoVOInSoonFilms(FilmT filmT)
    {

        FilmInfoVO filmInfoVO = new FilmInfoVO();
        filmInfoVO.setFilmId("" + filmT.getUuid());
        filmInfoVO.setFilmType(filmT.getFilmType());
        filmInfoVO.setImgAddress(filmT.getImgAddress());
        filmInfoVO.setFilmName(filmT.getFilmName());
        //预售票房就是期待数
        filmInfoVO.setExpectNum(filmT.getFilmPresalenum());
        //使用Guns自带的工具类转换时间
        filmInfoVO.setShowTime(DateUtil.getDay(filmT.getFilmTime()));
        return filmInfoVO;

    }

    public static FilmInfoVO filmT2FilmInfoVOInBoxRanking(FilmT filmT)
    {

        FilmInfoVO filmInfoVO = new FilmInfoVO();
        filmInfoVO.setFilmId("" + filmT.getUuid());
        filmInfoVO.setImgAddress(filmT.getImgAddress());
        filmInfoVO.setFilmName(filmT.getFilmName());
        filmInfoVO.setBoxNum(filmT.getFilmBoxOffice());
        return filmInfoVO;

    }

    public static FilmInfoVO filmT2FilmInfoVOInExpectRanking(FilmT filmT)
    {

        FilmInfoVO filmInfoVO = new FilmInfoVO();
        filmInfoVO.setFilmId("" + filmT.getUuid());
        filmInfoVO.setImgAddress(filmT.getImgAddress());
        filmInfoVO.setFilmName(filmT.getFilmName());
        filmInfoVO.setExpectNum(filmT.getFilmPresalenum());
        return filmInfoVO;

    }

    public static FilmInfoVO filmT2FilmInfoVOInTop100(FilmT filmT)
    {

        FilmInfoVO filmInfoVO = new FilmInfoVO();
        filmInfoVO.setFilmId("" + filmT.getUuid());
        filmInfoVO.setImgAddress(filmT.getImgAddress());
        filmInfoVO.setFilmName(filmT.getFilmName());
        filmInfoVO.setScore(filmT.getFilmScore());
        return filmInfoVO;

    }

    //  =============首页=========================


    //  ================分类列表====================
    public static CatInfoVO catDictT2CatInfoVO(CatDictT catDictT)
    {

        CatInfoVO catInfoVO = new CatInfoVO();
        catInfoVO.setCatId("" + catDictT.getUuid());
        catInfoVO.setCatName(catDictT.getShowName());
        //这个标志是前后端逻辑共同实现,因为默认访问时全部为true
        //因此在这里也设置默认值是true
        catInfoVO.setActive(false);

        return catInfoVO;
    }

    public static SourceInfoVO sourceDictT2SourceInfoVO(SourceDictT sourceDictT)
    {

        SourceInfoVO sourceInfoVO = new SourceInfoVO();
        sourceInfoVO.setSourceId("" + sourceDictT.getUuid());
        sourceInfoVO.setSourceName(sourceDictT.getShowName());
        //这个标志是前后端逻辑共同实现,因为默认访问时全部为true
        //因此在这里也设置默认值是true
        sourceInfoVO.setActive(false);

        return sourceInfoVO;
    }

    public static YearInfoVO yearDictT2YearInfoVO(YearDictT yearDictT)
    {
        YearInfoVO yearInfoVO = new YearInfoVO();

        yearInfoVO.setYearId("" + yearDictT.getUuid());
        yearInfoVO.setYearName(yearDictT.getShowName());
        //这个标志是前后端逻辑共同实现,因为默认访问时全部为true
        //因此在这里也设置默认值是true
        yearInfoVO.setActive(false);


        return yearInfoVO;
    }


    public static FilmInfoVO filmT2FilmInCondition(FilmT filmT)
    {
        FilmInfoVO filmInfoVO = new FilmInfoVO();
        filmInfoVO.setFilmId("" + filmT.getUuid());
        filmInfoVO.setFilmType(filmT.getFilmType());
        filmInfoVO.setImgAddress(filmT.getImgAddress());
        filmInfoVO.setFilmName(filmT.getFilmName());
        filmInfoVO.setFilmScore(filmT.getFilmScore());
        filmInfoVO.setBoxNum(filmT.getFilmBoxOffice());
        filmInfoVO.setExpectNum(filmT.getFilmPresalenum());
        filmInfoVO.setShowTime(DateUtil.getDay(filmT.getFilmTime()));
        return filmInfoVO;
    }


    public static FilmVO queryNotIndex(EntityWrapper<FilmT> wrapper, Page<FilmT> page, Integer nowPage, Integer nums, Integer sourceId, Integer yearId, Integer catId, FilmTMapper filmTMapper, List<FilmInfoVO> films, FilmVO filmVO)
    {
        //不是首页
        //如果sourceId,yearId,catId不是99,就分别加入各自的条件
        if (sourceId != 99)
        {
            wrapper.eq("film_source", sourceId);
        }
        if (yearId != 99)
        {
            wrapper.eq("film_date", yearId);
        }
        if (catId != 99)
        {
            //数据库中的格式是#2#3#22#
            //传入的则是单个数值如1,2等,应该使用模糊查询
            String catStr = "%#" + catId + "%#";
            wrapper.like("film_cat", catStr);
        }
        //查询出数据
        List<FilmT> filmTS = filmTMapper.selectPage(page, wrapper);
        //遍历封装赋值
        for (FilmT filmT : filmTS)
        {
            FilmInfoVO filmInfoVO = FilmUtils.filmT2FilmInCondition(filmT);
            films.add(filmInfoVO);
        }
        filmVO.setFilmInfo(films);
        //其他数据封装
        Integer totalCount = filmTMapper.selectCount(wrapper);
        int totalPage = (totalCount / nums) + 1;
        filmVO.setTotalPage(totalPage);
        filmVO.setNowPage(nowPage);

        return filmVO;
    }

    public static FilmInfoT getFilmInfoT(String filmId, FilmInfoTMapper filmInfoTMapper)
    {
        FilmInfoT filmInfoT = new FilmInfoT();
        filmInfoT.setFilmId(filmId);
        filmInfoT = filmInfoTMapper.selectOne(filmInfoT);
        return filmInfoT;
    }

}
