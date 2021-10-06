package com.wangm.dao;

import java.util.List;

import com.wangm.entity.User;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author wangm
 * @since 2021/10/6
 */
@Repository
public interface UserMapper {

    @Select("select * from user")
    List<User> list();

}
