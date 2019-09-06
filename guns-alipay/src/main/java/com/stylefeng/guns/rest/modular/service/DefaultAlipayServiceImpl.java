package com.stylefeng.guns.rest.modular.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.order.OrderServiceAPI;
import com.stylefeng.guns.api.pay.AliPayServiceAPI;
import com.stylefeng.guns.api.pay.vo.AliPayInfoVO;
import com.stylefeng.guns.api.pay.vo.AliPayResultVO;
import com.stylefeng.guns.rest.modular.alipay.Main;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
@Service(interfaceClass = AliPayServiceAPI.class)
public class DefaultAlipayServiceImpl implements AliPayServiceAPI
{

    @Reference(interfaceClass = OrderServiceAPI.class, check = false, group = "default")
    private OrderServiceAPI orderServiceAPI;

    private Main main = new Main();


    // 获取二维码地址
    @Override
    public AliPayInfoVO getQRCode(String orderId) throws FileNotFoundException
    {

        // 获取二维码地址
        String filePath = main.test_trade_precreate(orderId, orderServiceAPI);
        // 如果地址为空，则表示获取二维码不成功
        if (filePath == null || filePath.trim().length() == 0)
        {
            return null;
        }
        else
        {
            AliPayInfoVO aliPayInfoVO = new AliPayInfoVO();
            aliPayInfoVO.setOrderId(orderId);
            aliPayInfoVO.setQRCodeAddress(filePath);
            return aliPayInfoVO;
        }
    }

    // 获取订单支付状态
    @Override
    public AliPayResultVO getOrderStatus(String orderId)
    {
        boolean isSuccess = false;
        long t1 = System.currentTimeMillis();

        // 获取订单支付状态
        while (true)
        {
            //十五分钟不支付,就返回空,支付失败
            long t2 = System.currentTimeMillis();
            isSuccess = main.test_trade_query(orderId, orderServiceAPI);
            if (t2 - t1 > 15 * 60 * 1000 || isSuccess)
            {
                break;
            }
            else
            {
                return null;
            }
        }
        if (isSuccess)
        {
            AliPayResultVO aliPayResultVO = new AliPayResultVO();
            aliPayResultVO.setOrderId(orderId);
            aliPayResultVO.setOrderStatus(1);
            aliPayResultVO.setOrderMsg("支付成功");
            return aliPayResultVO;
        }
        return null;
    }

}
