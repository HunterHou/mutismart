package com.hd.mutismart.site.controller;

import com.hd.mutismart.base.result.MessageCode;
import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.service.entity.User;
import com.hd.mutismart.service.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping("user/add")
    public ReqResult add(User user) {
        return userService.insert(user);
    }

    @RequestMapping("user/delete")
    public ReqResult delete(User user) {

        return userService.delete(user);
    }

    @RequestMapping("user/all")
    public ReqResult selectList() {
        ReqResult reqResult = new ReqResult(MessageCode.SUCCESS);
        reqResult.setData(userService.query());
        return reqResult;
    }
}
