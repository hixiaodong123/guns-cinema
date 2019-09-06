package com.stylefeng.guns.api.pay;

import com.stylefeng.guns.api.pay.vo.AliPayInfoVO;
import com.stylefeng.guns.api.pay.vo.AliPayResultVO;

import java.io.FileNotFoundException;

public interface AliPayServiceAPI {

    AliPayInfoVO getQRCode(String orderId) throws FileNotFoundException;

    AliPayResultVO getOrderStatus(String orderId);

}
