package com.wangm.controller;

import com.wangm.entity.User;
import com.wangm.utils.RedisTemplateUtils;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangm
 * @since 2021/9/20
 */
@RestController
public class RedisController {

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

}
