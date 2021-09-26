package com.wangm.utils;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * 使用redisTemplate代替StringRedisTemplate
 *
 * @author wangm
 * @since 2021/9/20
 */
public class RedisTemplateUtils {

    private static RedisTemplate<String, Object> redisTemplate;


    public static void setObject(String key, Object value) {
        setObject(key, value, 1000L);
    }

    public static void setObject(String key, Object value, Long timeout) {
        redisTemplate.opsForValue().set(key, value);
        if (null != timeout) {
            redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
        }
    }

    public static Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    public static void init(RedisTemplate template) {
        redisTemplate = template;
    }
}
