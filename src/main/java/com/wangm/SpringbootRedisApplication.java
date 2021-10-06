package com.wangm;

import com.wangm.utils.RedisTemplateUtils;
import com.wangm.utils.RedisUtils;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootApplication
@MapperScan(basePackages = {"com.wangm.dao"})
@EnableCaching
public class SpringbootRedisApplication implements ApplicationContextAware {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisApplication.class, args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        StringRedisTemplate stringTemplateBean = applicationContext.getBean(StringRedisTemplate.class);
        RedisTemplate templateBean = applicationContext.getBean("redisTemplate", RedisTemplate.class);
        RedisUtils.init(stringTemplateBean);
        RedisTemplateUtils.init(templateBean);
    }


}
