package com.stylefeng.guns.rest.order;

import com.alibaba.dubbo.config.annotation.Service;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.api.order.OrderServiceAPI;
import com.stylefeng.guns.api.order.bean.OrderVo;
import com.stylefeng.guns.rest.common.persistence.dao.Order2017Mapper;
import com.stylefeng.guns.rest.common.persistence.dao.Order2018Mapper;
import com.stylefeng.guns.rest.common.persistence.dao.OrderMapper;

import com.stylefeng.guns.rest.common.persistence.model.SeatJson;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

/**
 * @description: 订单业务提供
 * @author: Lime
 * @create: 2019-08-29 21:48
 **/

@Component
@Service(interfaceClass = OrderServiceAPI.class)
public class OrderServiceImpl implements OrderServiceAPI {
    @Autowired
    Order2017Mapper order2017Mapper;
    @Autowired
    Order2018Mapper order2018Mapper;
    @Autowired
    OrderMapper orderMapper;
    @Override
    public boolean isTrueSeats(String fieldId, String soldSeats) {
//        String seatsTable=orderMapper.querySeats(fieldId);
//        File seatsFile=new File(seatsTable);
//        try {
//            String content= FileUtils.readFileToString(seatsFile,"utf-8");
//            SeatJson seatJson= JSON.parseObject(content,SeatJson.class);
//            String id=seatJson.getIds();
//            if(id.contains(soldSeats)){
//                return true;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//        return false;
        return false;
    }

    @Override
    public boolean isSoldSeats(String fieldId, String soldSeats) {
        return false;
    }

    @Override
    public OrderVo checekOrder(String fieldId, String soldSeats, String seatsName) {
        return null;
    }
}
