package com.fandf.mall.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fandf.mall.order.model.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper extends BaseMapper<Order> {
}