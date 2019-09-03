package com.stylefeng.guns.api.cinema.vo;


import java.io.Serializable;

public class CinemaQueryVO implements Serializable
{

    private static final long serialVersionUID = 1881684834470113003L;
    private Integer brandId=99;
    private Integer districtId=99;
    private Integer hallType=99;
    private Integer pageSize=12;
    private Integer nowPage=1;

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public Integer getBrandId()
    {
        return brandId;
    }

    public void setBrandId(Integer brandId)
    {
        this.brandId = brandId;
    }

    public Integer getDistrictId()
    {
        return districtId;
    }

    public void setDistrictId(Integer districtId)
    {
        this.districtId = districtId;
    }

    public Integer getHallType()
    {
        return hallType;
    }

    public void setHallType(Integer hallType)
    {
        this.hallType = hallType;
    }

    public Integer getPageSize()
    {
        return pageSize;
    }

    public void setPageSize(Integer pageSize)
    {
        this.pageSize = pageSize;
    }

    public Integer getNowPage()
    {
        return nowPage;
    }

    public void setNowPage(Integer nowPage)
    {
        this.nowPage = nowPage;
    }
}
