package com.fandf.mall.order.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.fandf.mall.order.model.Order;
import com.fandf.mall.order.service.OrderService;
import com.fandf.mall.util.RespCode;
import com.fandf.mall.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /***
     * 添加订单
     */
    @PostMapping
    public RespResult add(@RequestBody Order order){
        String userName = "gp";
        order.setUsername(userName);
        order.setCreateTime(new Date());
        order.setUpdateTime(order.getCreateTime());
        order.setId(IdWorker.getIdStr());
        order.setOrderStatus(0);
        order.setPayStatus(0);
        order.setIsDelete(0);

        //添加订单
        Boolean bo = orderService.add(order);
        return bo? RespResult.ok():RespResult.error(RespCode.SYSTEM_ERROR);
    }
}