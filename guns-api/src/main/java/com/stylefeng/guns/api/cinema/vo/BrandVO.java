package com.stylefeng.guns.api.cinema.vo;


import java.io.Serializable;
public class BrandVO implements Serializable {

    private static final long serialVersionUID = 8129906784730010594L;
    private String brandId;
    private String brandName;
    private boolean isActive;

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getBrandId()
    {
        return brandId;
    }

    public void setBrandId(String brandId)
    {
        this.brandId = brandId;
    }

    public String getBrandName()
    {
        return brandName;
    }

    public void setBrandName(String brandName)
    {
        this.brandName = brandName;
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
