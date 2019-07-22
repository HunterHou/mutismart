package com.hd.mutismart.service.service;

import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.service.entity.User;

import java.util.List;

public interface IUserService {
    List<User> query();

    ReqResult insert(User user);

    ReqResult update(User user);

    ReqResult delete(User user);

    ReqResult delete(List<String> ids);
}
