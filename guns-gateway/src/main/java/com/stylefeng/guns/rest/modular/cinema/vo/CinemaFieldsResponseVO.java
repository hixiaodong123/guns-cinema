package com.stylefeng.guns.rest.modular.cinema.vo;

import com.stylefeng.guns.api.cinema.vo.CinemaInfoVO;
import com.stylefeng.guns.api.cinema.vo.FilmInfoVO;

import java.util.List;

public class CinemaFieldsResponseVO
{

    public CinemaInfoVO getCinemaInfo()
    {
        return cinemaInfo;
    }

    public void setCinemaInfo(CinemaInfoVO cinemaInfo)
    {
        this.cinemaInfo = cinemaInfo;
    }

    public List<FilmInfoVO> getFilmList()
    {
        return filmList;
    }

    public void setFilmList(List<FilmInfoVO> filmList)
    {
        this.filmList = filmList;
    }

    private CinemaInfoVO cinemaInfo;
    private List<FilmInfoVO> filmList;

}
