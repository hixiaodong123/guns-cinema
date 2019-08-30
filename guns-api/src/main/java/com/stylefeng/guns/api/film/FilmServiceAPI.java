package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.bean.*;

import java.util.List;

/**
 * @description: 影片业务接口
 * @author: Lime
 * @create: 2019-08-29 22:01
 **/

public interface FilmServiceAPI {
    

    List<BannerVo> getBanners();

    List<VoFilmInfo> getExpectRanking();

    List<VoFilmInfo> getTop100();

    List<VoFilmInfo> getBoxRnking();

    FilmVo getHotFilms();

    FilmVo getSoonFilms();

    List<CatInfo> getCat(Integer catId);

    List<YearInfo> getYear(Integer yearId);

    List<SourceInfo> getSource(Integer sourceId);
}
