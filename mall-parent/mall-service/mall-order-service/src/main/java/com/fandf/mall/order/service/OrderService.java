package com.fandf.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fandf.mall.order.model.Order;

public interface OrderService extends IService<Order> {
    //添加订单
    Boolean add(Order order);
}