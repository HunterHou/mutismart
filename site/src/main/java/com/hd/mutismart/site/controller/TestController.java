package com.hd.mutismart.site.controller;

import com.hd.mutismart.service.entity.User;
import com.hd.mutismart.service.mapper.UserMapper;
import com.hd.mutismart.service.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private IUserService userService;

    @RequestMapping("test")
    public String test() {
        return "ok";
    }

    @RequestMapping("users")
    public List<User> selectList() {
        return userService.query();
    }
}
