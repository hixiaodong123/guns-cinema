package com.stylefeng.guns.api.cinema.vo;


import java.io.Serializable;

public class CinemaInfoVO implements Serializable
{

    private static final long serialVersionUID = 5944396290296320598L;
    private String cinemaId;
    private String imgUrl;
    private String cinemaName;
    private String cinemaAdress;
    private String cinemaPhone;

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getCinemaId()
    {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId)
    {
        this.cinemaId = cinemaId;
    }

    public String getImgUrl()
    {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl)
    {
        this.imgUrl = imgUrl;
    }

    public String getCinemaName()
    {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName)
    {
        this.cinemaName = cinemaName;
    }

    public String getCinemaAdress()
    {
        return cinemaAdress;
    }

    public void setCinemaAdress(String cinemaAdress)
    {
        this.cinemaAdress = cinemaAdress;
    }

    public String getCinemaPhone()
    {
        return cinemaPhone;
    }

    public void setCinemaPhone(String cinemaPhone)
    {
        this.cinemaPhone = cinemaPhone;
    }
}
