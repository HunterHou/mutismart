package com.hd.mutismart.cache.util;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.hd.mutismart.base.result.ReqResult;

@Component
public class RedisUtils {

    private static StringRedisTemplate redisTemplate;

    @Autowired
    public RedisUtils(StringRedisTemplate template){
        this.redisTemplate = template;
    }

    public static <T> ReqResult setValue(String name, T value) {
        String valueStr = JSON.toJSONString(value);
        redisTemplate.opsForValue().set(name, valueStr);
        return ReqResult.success();
    }

    public static String getValue(String name) {
        String value = getValue(name, String.class);
        return value;
    }

    public static <T> T getValue(String name, Class<T> clazz) {
        String val = redisTemplate.opsForValue().get(name);

        if (StringUtils.isBlank(val)) {
            return null;
        }
        T result = JSON.parseObject(val, clazz);
        return result;
    }

    public static <T> List<T> getList(String name, Class clazz) {

        String val = redisTemplate.opsForValue().get(name);
        if (StringUtils.isBlank(val)) {
            return null;
        }
        List<T> result = JSON.parseArray(val, clazz);
        return result;
    }
}
