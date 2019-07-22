package com.hd.mutismart.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.service.entity.User;

import java.util.List;

public interface IUserService {
    List<User> query(User user);

    ReqResult insert(User user);

    ReqResult update(User user);

    ReqResult delete(User user);

    ReqResult delete(List<Long> ids);

    IPage<User> queryPage(User user);
}
