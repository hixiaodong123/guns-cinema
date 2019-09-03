package com.stylefeng.guns.api.cinema.vo;

import java.io.Serializable;

public class OrderQueryVO implements Serializable
{
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

    public String getFilmPrice()
    {
        return filmPrice;
    }

    public void setFilmPrice(String filmPrice)
    {
        this.filmPrice = filmPrice;
    }

    private static final long serialVersionUID = -3134779484244974046L;
    private String cinemaId;
    private String filmPrice;

}
