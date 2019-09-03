package com.stylefeng.guns.api.film.vo.film;

import java.io.Serializable;

/**
 * @description: 封装cat
 * @author: Lime
 * @create: 2019-08-30 23:24
 **/

public class CatInfoVO implements Serializable
{
    private static final long serialVersionUID = 664917792717634622L;

    private String catId;
    private String catName;
    private boolean isActive;

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getCatId()
    {
        return catId;
    }

    public void setCatId(String catId)
    {
        this.catId = catId;
    }

    public String getCatName()
    {
        return catName;
    }

    public void setCatName(String catName)
    {
        this.catName = catName;
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
