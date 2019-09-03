package com.stylefeng.guns.api.promo;


import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Mr.Xu
 * @since 2019-09-03
 */
public interface IMtimePromoService  {

    List<PromoVo> getPromo(Integer cinemaId);
}
