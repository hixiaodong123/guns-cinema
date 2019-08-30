package com.stylefeng.guns.api.film.bean;

import lombok.Data;

import java.util.List;
@Data
public class FilmIndexVo {
    private List<BannerVo>  banners;
    private List<FilmVo> hotFilms;
    private List<FilmVo> soonFilms;
    private List<VoFilmInfo> boxRanking;
    private List<VoFilmInfo> expectRanking;
    private List<VoFilmInfo> top100;
}
