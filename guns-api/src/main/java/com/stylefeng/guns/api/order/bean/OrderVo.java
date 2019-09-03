package com.stylefeng.guns.api.order.bean;

import lombok.Data;

@Data
public class OrderVo {
    private String orderId;
    private String filmName;
    private String fieldTime;
    private String cinemaName;
    private String seatsName;
    private String orderPrice;
    private String orderTimestamp;

}
