package com.stylefeng.guns.api.cinema.vo;


import java.io.Serializable;
public class HallTypeVO implements Serializable {
    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getHalltypeId()
    {
        return halltypeId;
    }

    public void setHalltypeId(String halltypeId)
    {
        this.halltypeId = halltypeId;
    }

    public String getHalltypeName()
    {
        return halltypeName;
    }

    public void setHalltypeName(String halltypeName)
    {
        this.halltypeName = halltypeName;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean active)
    {
        isActive = active;
    }

    private static final long serialVersionUID = 4208045810541195956L;
    private String halltypeId;
    private String halltypeName;
    private boolean isActive;


}
