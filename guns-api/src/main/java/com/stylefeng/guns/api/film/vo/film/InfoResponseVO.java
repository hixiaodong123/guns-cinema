package com.stylefeng.guns.api.film.vo.film;

import com.stylefeng.guns.api.film.vo.film.FilmActorAndDirectorDescVO;
import com.stylefeng.guns.api.film.vo.film.ImgVO;

import java.io.Serializable;

/**
 * @description: 返回值类型
 * @author: Lime
 * @create: 2019-09-02 20:47
 **/

public class InfoResponseVO implements Serializable
{

    private static final long serialVersionUID = 4944355252787747047L;
    private String biography;
    private FilmActorAndDirectorDescVO actors;
    private ImgVO imgVO;
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

    public FilmActorAndDirectorDescVO getActors()
    {
        return actors;
    }

    public void setActors(FilmActorAndDirectorDescVO actors)
    {
        this.actors = actors;
    }

    public ImgVO getImgVO()
    {
        return imgVO;
    }

    public void setImgVO(ImgVO imgVO)
    {
        this.imgVO = imgVO;
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
