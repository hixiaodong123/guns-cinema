package com.stylefeng.guns.rest.modular.cinema.vo;

import com.stylefeng.guns.api.cinema.vo.CinemaVO;

import java.util.List;

public class CinemaListResponseVO
{

    private List<CinemaVO> cinemas;

    public List<CinemaVO> getCinemas()
    {
        return cinemas;
    }

    public void setCinemas(List<CinemaVO> cinemas)
    {
        this.cinemas = cinemas;
    }
}
