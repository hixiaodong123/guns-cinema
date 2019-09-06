package com.stylefeng.guns.rest.pay;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.api.order.OrderServiceAPI;
import com.stylefeng.guns.api.pay.AliPayServiceAPI;
import com.stylefeng.guns.api.pay.vo.AliPayInfoVO;
import com.stylefeng.guns.api.pay.vo.AliPayResultVO;
import com.stylefeng.guns.rest.pay.model.builder.AlipayTradeQueryRequestBuilder;
import com.stylefeng.guns.rest.pay.model.result.AlipayF2FQueryResult;
import com.stylefeng.guns.rest.pay.service.AlipayTradeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;

@Slf4j
@Component
@Service(interfaceClass = AliPayServiceAPI.class)
public class PayServiceImpl implements AliPayServiceAPI
{

    @Reference(interfaceClass = OrderServiceAPI.class, check = false, group = "default")
    private OrderServiceAPI orderServiceAPI;

    // 支付宝当面付2.0服务
    private static AlipayTradeService tradeService;

    // 获取二维码地址
    @Override
    public AliPayInfoVO getQRCode(String orderId) throws FileNotFoundException
    {

        // 获取二维码地址
        String path = PayUtils.test_trade_precreate(orderId);
        String filePath = "https://lixishuang.oss-cn-beijing.aliyuncs.com/" + path + ".png";
        // 如果地址为空，则表示获取二维码不成功
        if (filePath.trim().length() == 0)
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

        // 获取订单支付状态
        boolean isSuccess = trade_query(orderId);
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

    // 测试当面付2.0查询订单
    public boolean trade_query(String orderId)
    {
        boolean flag = false;
        // (必填) 商户订单号，通过此商户订单号查询当面付的交易状态
        String outTradeNo = orderId;

        // 创建查询请求builder，设置请求参数
        AlipayTradeQueryRequestBuilder builder = new AlipayTradeQueryRequestBuilder().setOutTradeNo(outTradeNo);

        AlipayF2FQueryResult result = tradeService.queryTradeResult(builder);
        switch (result.getTradeStatus())
        {
            case SUCCESS:
                log.info("查询返回该订单支付成功: )");

                // 当订单支付成功状态时，修改订单状态为1
                flag = orderServiceAPI.paySuccess(orderId);

                break;

            case FAILED:
                log.error("查询返回该订单支付失败或被关闭!!!");
                break;

            case UNKNOWN:
                log.error("系统异常，订单支付状态未知!!!");
                break;

            default:
                log.error("不支持的交易状态，交易返回异常!!!");
                break;
        }
        return flag;
    }
}
