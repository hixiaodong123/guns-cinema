package com.stylefeng.guns.rest.common.persistence.dao;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.api.order.vo.OrderVO;
import com.stylefeng.guns.rest.common.persistence.model.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单信息表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2019-08-29
 */
public interface OrderMapper extends BaseMapper<Order>
{

    String getSeatsByFieldId(@Param("fieldId") String fieldId);

    OrderVO getOrderInfoById(@Param("orderId") String orderId);

    List<OrderVO> getOrdersByUserId(@Param("userId")Integer userId, Page<OrderVO> page);

    String getSoldSeatsByFieldId(@Param("fieldId")Integer fieldId);

}
