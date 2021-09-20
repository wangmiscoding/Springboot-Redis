package com.wangm;

import com.wangm.utils.RedisUtils;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
public class SpringbootRedisApplication implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        StringRedisTemplate templateBean = applicationContext.getBean(StringRedisTemplate.class);
        RedisUtils.init(templateBean);
    }


}