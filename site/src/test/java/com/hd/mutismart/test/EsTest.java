package com.hd.mutismart.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.search.entity.EsUser;
import com.hd.mutismart.search.service.IEsUserService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsTest.class)
@MapperScan(basePackages = { "com.hd.mutismart.*.mapper" })
@EnableElasticsearchRepositories(basePackages = { "com.hd.mutismart.search.mapper" })
@ComponentScan(basePackages = { "com.hd.mutismart" })
public class EsTest {

    @Resource
    private IEsUserService esUserService;

    @Test
    public void query() {
        EsUser user = new EsUser();
        user.setPage(1);
        user.setSize(5);
        ReqResult users = esUserService.search(user);
        System.out.println(users.toString());
    }

    @Test
    public void sync() {
        ReqResult users = esUserService.sync();
        System.out.println(users.toString());
    }
}
