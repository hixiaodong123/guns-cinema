package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;

public class CinemaVO implements Serializable {

    private static final long serialVersionUID = -306739461880517743L;
    private String uuid;
    private String cinemaName;
    private String cinemaAddress;
    private String minimumPrice;

    public String getCinemaAddress()
    {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress)
    {
        this.cinemaAddress = cinemaAddress;
    }

    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getUuid()
    {
        return uuid;
    }

    public void setUuid(String uuid)
    {
        this.uuid = uuid;
    }

    public String getCinemaName()
    {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName)
    {
        this.cinemaName = cinemaName;
    }

    public String getMinimumPrice()
    {
        return minimumPrice;
    }

    public void setMinimumPrice(String minimumPrice)
    {
        this.minimumPrice = minimumPrice;
    }
}
