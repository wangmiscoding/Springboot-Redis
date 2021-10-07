package com.wangm.controller;

import java.util.UUID;

import com.wangm.dao.OrderMapper;
import com.wangm.entity.Order;
import com.wangm.utils.RedisUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangm
 * @since 2021/10/7
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    OrderMapper orderMapper;

    @GetMapping("add")
    public String addOrder() {
        //提前生成订单token 临时且唯一
        String orderToken = UUID.randomUUID().toString();
        long orderId = System.currentTimeMillis();
        Order order = new Order().setOrderName("永久").setOrderId(orderId).setOrderToken(orderToken).setOrderStatus(0);
        int result = orderMapper.insert(order);
        RedisUtils.setString(orderToken, String.valueOf(orderId), 10L);
        return String.valueOf(result);
    }
}
