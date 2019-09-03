package com.stylefeng.guns.api.film.vo.index;

import java.io.Serializable;
import java.util.List;

/**
 * @description: 影片的封装类
 * @author: Lime
 * @create: 2019-08-30 17:58
 **/

public class FilmVO implements Serializable
{
    private static final long serialVersionUID = -1390791760894461515L;

    private Integer nowPage;
    private Integer totalPage;
    private Integer filmNum;
    private List<FilmInfoVO> filmInfo;

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public Integer getNowPage()
    {
        return nowPage;
    }

    public void setNowPage(Integer nowPage)
    {
        this.nowPage = nowPage;
    }

    public Integer getTotalPage()
    {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage)
    {
        this.totalPage = totalPage;
    }

    public Integer getFilmNum()
    {
        return filmNum;
    }

    public void setFilmNum(Integer filmNum)
    {
        this.filmNum = filmNum;
    }

    public List<FilmInfoVO> getFilmInfo()
    {
        return filmInfo;
    }

    public void setFilmInfo(List<FilmInfoVO> filmInfo)
    {
        this.filmInfo = filmInfo;
    }
}
