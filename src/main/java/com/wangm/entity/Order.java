package com.wangm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wangm
 * @since 2021/10/7
 */
@Data
@Accessors(chain = true)
@TableName("t_order")
public class Order {
    @TableId(type = IdType.AUTO)
    private Long id;
    @TableField("order_name")
    private String orderName;
    @TableField("order_status")
    private Integer orderStatus;
    @TableField("order_token")
    private String orderToken;
    @TableField("order_id")
    private Long orderId;
}
