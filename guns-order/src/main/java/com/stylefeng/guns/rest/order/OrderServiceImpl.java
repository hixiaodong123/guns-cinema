package com.stylefeng.guns.rest.order;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.order.OrderServiceAPI;
import org.springframework.stereotype.Component;

/**
 * @description: 订单业务提供
 * @author: Lime
 * @create: 2019-08-29 21:48
 **/

@Component
@Service(interfaceClass = OrderServiceAPI.class)
public class OrderServiceImpl implements OrderServiceAPI
{
}
