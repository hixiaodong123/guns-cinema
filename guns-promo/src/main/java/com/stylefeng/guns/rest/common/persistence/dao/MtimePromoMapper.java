package com.stylefeng.guns.rest.common.persistence.dao;

import com.stylefeng.guns.rest.common.persistence.model.MtimePromo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mr.Xu
 * @since 2019-09-03
 */
public interface MtimePromoMapper extends BaseMapper<MtimePromo> {

    List<MtimePromo> selectListByCinemaId(@Param("cinemaId") Integer cinemaId);
}
