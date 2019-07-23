package com.hd.mutismart.site.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.mutismart.base.result.MessageCode;
import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.service.entity.User;
import com.hd.mutismart.service.service.IUserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("user/add")
    public ReqResult add(User user) {
        return userService.insert(user);
    }

    @RequestMapping("user/update")
    public ReqResult update(User user) {
        return userService.update(user);
    }

    @RequestMapping("user/delete")
    public ReqResult delete(User user) {

        return userService.delete(user);
    }

    @RequestMapping("user/all")
    public ReqResult selectList(User user) {
        ReqResult reqResult = new ReqResult(MessageCode.SUCCESS);
        reqResult.setData(userService.query(user));
        return reqResult;
    }

    @RequestMapping("user/page")
    public ReqResult selectPage(User user) {
        ReqResult reqResult = new ReqResult(MessageCode.SUCCESS);
        reqResult.setData(userService.queryPage(user));
        return reqResult;
    }
}
