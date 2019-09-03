package com.stylefeng.guns.api.cinema.vo;


import java.io.Serializable;

public class HallInfoVO implements Serializable
{
    public static long getSerialVersionUID()
    {
        return serialVersionUID;
    }

    public String getHallFieldId()
    {
        return hallFieldId;
    }

    public void setHallFieldId(String hallFieldId)
    {
        this.hallFieldId = hallFieldId;
    }

    public String getHallName()
    {
        return hallName;
    }

    public void setHallName(String hallName)
    {
        this.hallName = hallName;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public String getSeatFile()
    {
        return seatFile;
    }

    public void setSeatFile(String seatFile)
    {
        this.seatFile = seatFile;
    }

    public String getSoldSeats()
    {
        return soldSeats;
    }

    public void setSoldSeats(String soldSeats)
    {
        this.soldSeats = soldSeats;
    }

    private static final long serialVersionUID = 1610609603271974114L;
    private String hallFieldId;
    private String hallName;
    private String price;
    private String seatFile;
    // 已售座位必须关联订单才能查询
    private String soldSeats;

}
