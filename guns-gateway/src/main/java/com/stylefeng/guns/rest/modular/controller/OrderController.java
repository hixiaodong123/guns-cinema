package com.stylefeng.guns.rest.modular.controller;






import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.order.OrderServiceAPI;
import com.stylefeng.guns.api.order.bean.OrderVo;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/order")
public class OrderController {
//    @Reference(interfaceClass = OrderServiceAPI.class,check = false)
//    OrderServiceAPI orderServiceAPI;
//    @RequestMapping("/buyTickets")
//    public ResponseVO buyTickets(String fieldId,String soldSeats,String seatsName){
//        if(fieldId!=null&&soldSeats!=null&&seatsName!=null){
//            if(orderServiceAPI.isTrueSeats(fieldId,soldSeats)){
//                if(orderServiceAPI.isSoldSeats(fieldId,soldSeats)){
//                    OrderVo orderVo=orderServiceAPI.checekOrder(fieldId,soldSeats,seatsName);
//                    return ResponseVO.success(orderVo);
//                }
//            }
//        }
//        return ResponseVO.systemFail("参数异常");
//    }
}
