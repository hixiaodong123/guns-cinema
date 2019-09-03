package com.stylefeng.guns.api.order;

import com.stylefeng.guns.api.order.bean.OrderVo;

/**
 * @description: 订单模块业务API
 * @author: Lime
 * @create: 2019-08-29 21:49
 **/

public interface OrderServiceAPI
{
    boolean isTrueSeats(String fieldId, String soldSeats);

    boolean isSoldSeats(String fieldId, String soldSeats);

    OrderVo checekOrder(String fieldId, String soldSeats, String seatsName);
}
