package com.stylefeng.guns.rest.modular.film.vo;

import com.stylefeng.guns.api.film.vo.index.BannerVO;
import com.stylefeng.guns.api.film.vo.index.FilmInfoVO;
import com.stylefeng.guns.api.film.vo.index.FilmVO;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 用于封装影院首页展示需要的数据
 * @author: Lime
 * @create: 2019-08-30 18:02
 **/

public class FilmIndexVO implements Serializable
{
    private static final long serialVersionUID = 4803462428288523321L;
    private List<BannerVO> banners;
    private FilmVO hotFilms;
    private FilmVO soonFilms;
    private List<FilmInfoVO> boxRanking;
    private List<FilmInfoVO> expectRanking;
    private List<FilmInfoVO> top100;

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public List<BannerVO> getBanners()
    {
        return banners;
    }

    public void setBanners(List<BannerVO> banners)
    {
        this.banners = banners;
    }

    public FilmVO getHotFilms()
    {
        return hotFilms;
    }

    public void setHotFilms(FilmVO hotFilms)
    {
        this.hotFilms = hotFilms;
    }

    public FilmVO getSoonFilms()
    {
        return soonFilms;
    }

    public void setSoonFilms(FilmVO soonFilms)
    {
        this.soonFilms = soonFilms;
    }

    public List<FilmInfoVO> getBoxRanking()
    {
        return boxRanking;
    }

    public void setBoxRanking(List<FilmInfoVO> boxRanking)
    {
        this.boxRanking = boxRanking;
    }

    public List<FilmInfoVO> getExpectRanking()
    {
        return expectRanking;
    }

    public void setExpectRanking(List<FilmInfoVO> expectRanking)
    {
        this.expectRanking = expectRanking;
    }

    public List<FilmInfoVO> getTop100()
    {
        return top100;
    }

    public void setTop100(List<FilmInfoVO> top100)
    {
        this.top100 = top100;
    }
}
