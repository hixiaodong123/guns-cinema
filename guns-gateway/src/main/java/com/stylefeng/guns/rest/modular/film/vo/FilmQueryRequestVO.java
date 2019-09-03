package com.stylefeng.guns.rest.modular.film.vo;

import java.io.Serializable;

/**
 * @description: 封装前端传来的影片查询条件
 * @author: Lime
 * @create: 2019-09-02 10:35
 **/

public class FilmQueryRequestVO implements Serializable
{
    private static final long serialVersionUID = 6573468540439263031L;
    private Integer showType = 1;
    private Integer sortId = 1;
    private Integer catId = 99;
    private Integer sourceId = 99;
    private Integer yearId = 99;
    private Integer nowPage = 1;
    private Integer pageSize = 18;

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public Integer getShowType()
    {
        return showType;
    }

    public void setShowType(Integer showType)
    {
        this.showType = showType;
    }

    public Integer getSortId()
    {
        return sortId;
    }

    public void setSortId(Integer sortId)
    {
        this.sortId = sortId;
    }

    public Integer getCatId()
    {
        return catId;
    }

    public void setCatId(Integer catId)
    {
        this.catId = catId;
    }

    public Integer getSourceId()
    {
        return sourceId;
    }

    public void setSourceId(Integer sourceId)
    {
        this.sourceId = sourceId;
    }

    public Integer getYearId()
    {
        return yearId;
    }

    public void setYearId(Integer yearId)
    {
        this.yearId = yearId;
    }

    public Integer getNowPage()
    {
        return nowPage;
    }

    public void setNowPage(Integer nowPage)
    {
        this.nowPage = nowPage;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }
}
