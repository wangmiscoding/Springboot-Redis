package com.wangm.entity;

import java.io.Serializable;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author wangm
 * @since 2021/9/20
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private Long userId;
    private String username;
}
