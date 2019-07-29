package com.hd.mutismart.site.restcontroller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hd.mutismart.base.annotation.Log;
import com.hd.mutismart.base.result.MessageCode;
import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.service.entity.User;
import com.hd.mutismart.service.service.IUserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("user/add")
    public ReqResult add(@ApiParam(name = "user", value = "用户信息", required = false) User user) {
        return userService.insert(user);
    }

    @GetMapping("user/update")
    public ReqResult update(@ApiParam(name = "user", value = "用户信息", required = false) User user) {
        return userService.update(user);
    }

    @GetMapping("user/delete")
    public ReqResult delete(@ApiParam(name = "user", value = "用户信息", required = false) User user) {
        return userService.delete(user);
    }

    @GetMapping("user/all")
    @Log("用户查询")
    @ApiOperation(value = "全部用户查询")
    public ReqResult selectList(@ApiParam(name = "user", value = "用户信息", required = false) User user) {
        ReqResult reqResult = new ReqResult(MessageCode.SUCCESS);
        reqResult.setData(userService.query(user));
        return reqResult;
    }

    @ApiOperation(value = "分页用户查询")
    @ApiImplicitParam(name = "user", value = "用户信息", dataType = "User")
    @GetMapping("user/page")
    public List<User> selectPage(User user) {
        return userService.queryPage(user).getRecords();
    }
}
