package com.stylefeng.guns.rest.pay;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.pay.PayServiceAPI;
import org.springframework.stereotype.Component;

/**
 * @description: 支付模块业务实现类
 * @author: Lime
 * @create: 2019-08-29 22:50
 **/
@Component
@Service(interfaceClass = PayServiceAPI.class)
public class PayServiceImpl implements PayServiceAPI
{
}
