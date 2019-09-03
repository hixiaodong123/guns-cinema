package com.stylefeng.guns.api.film.vo.film;

import java.io.Serializable;

/**
 * @description: 影片详情中的info04部分数据
 * @author: Lime
 * @create: 2019-09-02 17:39
 **/

public class FilmDescVO implements Serializable
{
    private static final long serialVersionUID = -842929359212928198L;
    private String biography;
    private String filmId;

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getBiography()
    {
        return biography;
    }

    public void setBiography(String biography)
    {
        this.biography = biography;
    }

    public String getFilmId()
    {
        return filmId;
    }

    public void setFilmId(String filmId)
    {
        this.filmId = filmId;
    }
}
