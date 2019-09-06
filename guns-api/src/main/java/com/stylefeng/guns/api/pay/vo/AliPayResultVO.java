package com.stylefeng.guns.api.pay.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AliPayResultVO implements Serializable {

    private String orderId;
    private Integer orderStatus;
    private String orderMsg;

}
