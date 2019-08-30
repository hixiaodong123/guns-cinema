package com.stylefeng.guns.api.film;

import com.stylefeng.guns.api.film.bean.BannerVo;
import com.stylefeng.guns.api.film.bean.FilmVo;
import com.stylefeng.guns.api.film.bean.VoFilmInfo;

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

    List<FilmVo> getHotFilms();

    List<FilmVo> getSoonFilms();
}
