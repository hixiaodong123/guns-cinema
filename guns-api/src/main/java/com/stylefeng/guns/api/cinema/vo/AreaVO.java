package com.stylefeng.guns.api.cinema.vo;


import java.io.Serializable;

public class AreaVO implements Serializable
{
    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getAreaId()
    {
        return areaId;
    }

    public void setAreaId(String areaId)
    {
        this.areaId = areaId;
    }

    public String getAreaName()
    {
        return areaName;
    }

    public void setAreaName(String areaName)
    {
        this.areaName = areaName;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
    }

    private static final long serialVersionUID = 8670569345555568557L;
    private String areaId;
    private String areaName;
    private boolean isActive;


}
