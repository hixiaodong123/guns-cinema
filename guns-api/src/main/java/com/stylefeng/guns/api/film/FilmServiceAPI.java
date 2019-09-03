package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.vo.film.*;
import com.stylefeng.guns.api.film.vo.index.BannerVO;
import com.stylefeng.guns.api.film.vo.index.FilmInfoVO;
import com.stylefeng.guns.api.film.vo.index.FilmVO;

import java.util.List;

/**
 * @description: 影片业务接口
 * @author: Lime
 * @create: 2019-08-29 22:01
 **/

public interface FilmServiceAPI
{
// ======  首页的API start  =========

    //获取banner
    List<BannerVO> getBanners();

    //获取热映电影
    FilmVO getHotFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId);

    //获取即将上映的电影(按照受欢迎程度排序)
    FilmVO getSoonFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId);

    //获取票房排行榜
    List<FilmInfoVO> getBoxRanking();

    //获取受期待排行榜
    List<FilmInfoVO> getExpectRanking();

    //获取Top100
    List<FilmInfoVO> getTop();

//  =======  首页的API end   =========


// ======  条件列表的API start  =========

    List<CatInfoVO> getCatInfo();

    List<SourceInfoVO> getSourceInfo();

    List<YearInfoVO> getYearInfo();

// ======  条件列表的API end  =========

// ======  影片条件查询的API start  =========

    // FilmVO getHotFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId);

    //  FilmVO getSoonFilms(boolean isLimit, int nums, int nowPage, int sortId, int sourceId, int yearId, int catId);

    FilmVO getClassicalFilms(int nums, int nowPage, int sortId, int sourceId, int yearId, int catId);

// ======  影片条件查询的API end  ===========


// ======= 影片详情 start =========

    //整体封装
    FilmDetailVO getFilmDetail(int searchType, String searchParam);

    //获取info4
    FilmDescVO getFilmDesc(String filmId);

    //图片
    ImgVO getImgs(String filmId);

    //演员
    List<ActorVO> getActor(String filmId);

    //导演
    ActorVO getDirector(String filmId);


// ======= 影片详情 end ============

}
