package com.stylefeng.guns.api.film.bean;

import lombok.Data;

import java.util.List;
@Data
public class FilmIndexVo {
    private List<BannerVo>  banners;
    private FilmVo hotFilms;
    private FilmVo soonFilms;
    private List<VoFilmInfo> boxRanking;
    private List<VoFilmInfo> expectRanking;
    private List<VoFilmInfo> top100;
}
