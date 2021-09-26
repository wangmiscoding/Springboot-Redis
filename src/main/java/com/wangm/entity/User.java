package com.wangm.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * @author wangm
 * @since 2021/9/20
 */
@Data
public class User implements Serializable {

    private Long userId;
    private String username;
}
