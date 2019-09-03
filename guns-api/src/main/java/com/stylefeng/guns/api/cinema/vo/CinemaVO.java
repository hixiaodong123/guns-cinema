package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;

public class CinemaVO implements Serializable {

    private static final long serialVersionUID = -306739461880517743L;
    private String uuid;
    private String cinemaName;
    private String address;
    private String minimumPrice;

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

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
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
