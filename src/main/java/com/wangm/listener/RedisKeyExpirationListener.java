package com.wangm.listener;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wangm.dao.OrderMapper;
import com.wangm.entity.Order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * 监听redis key 事件回调
 *
 * @author wangm
 * @since 2021/10/7
 */
@Component
@Slf4j
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    @Autowired
    OrderMapper orderMapper;

    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * 使用该方法监听 当我们的key失效的时候执行该方法
     *
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expiredKey = message.toString();
        log.info("订单token:" + expiredKey);
        Order order = orderMapper.selectOne(new LambdaQueryWrapper<Order>().eq(Order::getOrderToken, expiredKey));
        order.setOrderStatus(1);
        orderMapper.updateById(order);
    }
}
