package com.wangm.controller;

import java.util.List;

import com.wangm.dao.UserMapper;
import com.wangm.entity.User;
import com.wangm.utils.RedisTemplateUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangm
 * @since 2021/9/20
 */
@RestController
public class RedisController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("add")
    public String add(User user) {
//        String userString = JSONObject.toJSONString(user);
//        RedisUtils.setString("user", userString);
        RedisTemplateUtils.setObject("user", user);
        return "成功";
    }

    @GetMapping("user")
    public User get(String key) {
//        String s = RedisUtils.get(key);
//        return JSONObject.parseObject(s, User.class);
        return (User) RedisTemplateUtils.get(key);
    }

    /**
     * cacheNames:文件夹
     * key:真实的key
     *
     * @return
     */
    @GetMapping("all")
    @Cacheable(cacheNames = "member", key = "'allUser'")
    public List<User> list() {
        return userMapper.list();
    }


}
