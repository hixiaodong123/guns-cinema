package com.stylefeng.guns.rest.modular.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.api.promo.IMtimePromoService;
import com.stylefeng.guns.api.promo.PromoVo;
import com.stylefeng.guns.rest.modular.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/promo")
public class PromoController {
    @Reference(interfaceClass = IMtimePromoService.class,check = false)
    IMtimePromoService promoService;
    @RequestMapping("/getPromo/{cinemaId}")
    public ResponseVO getPromo(@PathVariable("cinemaId") Integer cinemaId){
        List<PromoVo> list=promoService.getPromo(cinemaId);
        return ResponseVO.success(list);
    }
    @RequestMapping("/getPromo")
    public ResponseVO getPromo(){
        List<PromoVo> list=promoService.getPromo(null);
        return ResponseVO.success(list);
    }
    @RequestMapping("/createOrder")
    public ResponseVO createOrder(Integer promoId,Integer amount){
        return ResponseVO.success("下单成功");
    }
}
