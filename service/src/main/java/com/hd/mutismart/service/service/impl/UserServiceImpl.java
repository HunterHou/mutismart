package com.hd.mutismart.service.service.impl;

import com.hd.mutismart.service.entity.User;
import com.hd.mutismart.service.mapper.UserMapper;
import com.hd.mutismart.service.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> query() {
        return userMapper.selectList(null);
    }
}
