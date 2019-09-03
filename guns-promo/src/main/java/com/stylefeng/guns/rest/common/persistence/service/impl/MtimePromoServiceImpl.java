package com.stylefeng.guns.rest.common.persistence.service.impl;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.api.promo.IMtimePromoService;
import com.stylefeng.guns.api.promo.PromoVo;
import com.stylefeng.guns.rest.common.persistence.dao.MtimePromoMapper;
import com.stylefeng.guns.rest.common.persistence.model.MtimePromo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Mr.Xu
 * @since 2019-09-03
 */
@Component
@Service(interfaceClass = IMtimePromoService.class)
public class MtimePromoServiceImpl implements IMtimePromoService {
    @Autowired
    MtimePromoMapper promoMapper;
    @Override
    public List<PromoVo> getPromo(Integer cinemaId) {
        List<MtimePromo> promoList=promoMapper.selectListByCinemaId(cinemaId);
        List<PromoVo> promoVoList=new ArrayList<>();
        for (MtimePromo promo : promoList) {
            PromoVo promoVo = new PromoVo();
            BeanUtils.copyProperties(promo,promoVo);
            promoVoList.add(promoVo);
        }
        return promoVoList;
    }
}
