package com.hd.mutismart.service.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.service.entity.User;

public interface IUserService {

    List<User> query(User user);

    ReqResult insert(User user);

    ReqResult update(User user);

    ReqResult delete(User user);

    ReqResult delete(List<Long> ids);

    IPage<User> queryPage(User user);
}
