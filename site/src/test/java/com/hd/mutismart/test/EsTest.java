package com.hd.mutismart.test;

import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.search.entity.EsUser;
import com.hd.mutismart.search.service.IEsUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsTest.class)
@MapperScan(basePackages = { "com.hd.mutismart.*.mapper" })
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
        ArrayList<EsUser> usersList = (ArrayList<EsUser>) users.getData();
        usersList.forEach(System.out::println);
    }

    @Test
    public void sync() {
        ReqResult users = esUserService.sync();
        System.out.println(users.toString());
    }
}
