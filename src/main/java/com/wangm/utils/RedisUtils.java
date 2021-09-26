package com.wangm.utils;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author wangm
 * @since 2021/9/20
 * 注意事项：对我们的redis的key设置一个有效期
 */
public class RedisUtils {

    /**
     * redis模板
     */
    private static StringRedisTemplate stringRedisTemplate;


    public static void setString(String key, String value) {
        setString(key, value, 1000L);
    }

    public static void setString(String key, String value, Long timeout) {
        stringRedisTemplate.opsForValue().set(key, value);
        if (null != timeout) {
            stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }
    }

    public static String get(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }


    public static void init(StringRedisTemplate template) {
        stringRedisTemplate = template;
    }
}
