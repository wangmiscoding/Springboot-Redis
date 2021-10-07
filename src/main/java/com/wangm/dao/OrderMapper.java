package com.wangm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangm.entity.Order;

import org.springframework.stereotype.Repository;

/**
 * @author wangm
 * @since 2021/10/6
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {


    int insert(Order order);
}
