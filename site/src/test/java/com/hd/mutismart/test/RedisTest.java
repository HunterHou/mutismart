package com.hd.mutismart.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.hd.mutismart.cache.util.RedisUtils;
import com.hd.mutismart.service.entity.User;
import com.hd.mutismart.service.service.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisTest.class)
@MapperScan(basePackages = { "com.hd.mutismart.*.mapper" })
@ComponentScan(basePackages = { "com.hd.mutismart" })
public class RedisTest {

    @Resource
    private IUserService userService;

    @Test
    public void setFoo() {
        RedisUtils.setValue("foo", "foo");
        RedisUtils.setValue("user", userService.query(null));
    }

    @Test
    public void getValue() {
        String value = RedisUtils.getValue("foo");
        System.out.println("foo:" + value);
    }

    @Test
    public void getList() {
        String value = RedisUtils.getValue("foo", String.class);
        System.out.println("foo:" + value);

        List<User> list = RedisUtils.getList("user", User.class);
        list.stream().forEach(System.out::println);
    }
}
