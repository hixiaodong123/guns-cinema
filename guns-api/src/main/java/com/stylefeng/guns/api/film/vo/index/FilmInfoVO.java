package com.stylefeng.guns.api.film.vo.index;

import java.io.Serializable;

/**
 * @description: 影片信息封装类
 * @author: Lime
 * @create: 2019-08-30 17:53
 **/

public class FilmInfoVO implements Serializable
{

    private static final long serialVersionUID = 1228068670067261746L;
    private String filmId;
    private Integer filmType;
    private String imgAddress;
    private String filmName;
    private String filmScore;
    private Integer expectNum;
    private String showTime;
    private Integer boxNum;
    private String score;

    public Integer getExpectNum()
    {
        return expectNum;
    }

    public void setExpectNum(Integer expectNum)
    {
        this.expectNum = expectNum;
    }

    public String getShowTime()
    {
        return showTime;
    }

    public void setShowTime(String showTime)
    {
        this.showTime = showTime;
    }

    public Integer getBoxNum()
    {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum)
    {
        this.boxNum = boxNum;
    }

    public String getScore()
    {
        return score;
    }

    public void setScore(String score)
    {
        this.score = score;
    }

    public String getFilmId()
    {
        return filmId;
    }

    public void setFilmId(String filmId)
    {
        this.filmId = filmId;
    }

    public Integer getFilmType()
    {
        return filmType;
    }

    public void setFilmType(Integer filmType)
    {
        this.filmType = filmType;
    }

    public String getImgAddress()
    {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress)
    {
        this.imgAddress = imgAddress;
    }

    public String getFilmName()
    {
        return filmName;
    }

    public void setFilmName(String filmName)
    {
        this.filmName = filmName;
    }

    public String getFilmScore()
    {
        return filmScore;
    }

    public void setFilmScore(String filmScore)
    {
        this.filmScore = filmScore;
    }
}
