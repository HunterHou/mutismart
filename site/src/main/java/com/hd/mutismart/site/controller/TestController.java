package com.hd.mutismart.site.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.mutismart.base.result.MessageCode;
import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.service.entity.User;
import com.hd.mutismart.service.service.IUserService;

@RestController
public class TestController {

    @Resource
    private IUserService userService;

    @RequestMapping("test")
    public ReqResult test() {
        return ReqResult.success();
    }

    @RequestMapping("users")
    public ReqResult selectList(User user) {
        ReqResult reqResult = new ReqResult(MessageCode.SUCCESS);
        reqResult.setData(userService.query(user));
        return reqResult;
    }
}
