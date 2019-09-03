package com.stylefeng.guns.api.film.vo.film;

import java.io.Serializable;

/**
 * @description: 封装year
 * @author: Lime
 * @create: 2019-08-30 23:24
 **/

public class YearInfoVO implements Serializable
{

    private static final long serialVersionUID = 7715868338745255545L;
    private String yearId;
    private String yearName;
    private boolean isActive;

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getYearId()
    {
        return yearId;
    }

    public void setYearId(String yearId)
    {
        this.yearId = yearId;
    }

    public String getYearName()
    {
        return yearName;
    }

    public void setYearName(String yearName)
    {
        this.yearName = yearName;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
    }
}
