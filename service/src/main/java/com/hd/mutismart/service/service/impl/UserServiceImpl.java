package com.hd.mutismart.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.service.entity.User;
import com.hd.mutismart.service.mapper.UserMapper;
import com.hd.mutismart.service.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> query() {
        Wrapper<User> queryWrapper = new QueryWrapper<User>();
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public ReqResult insert(User user) {
        user.setCreateTime(LocalDate.now());
        user.setDeleteFlag(false);
        userMapper.insert(user);
        ReqResult result = ReqResult.success();
        result.setId(user.getId());
        result.setData(user);
        return result;
    }

    @Override
    public ReqResult update(User user) {
        userMapper.updateById(user);
        ReqResult result = ReqResult.success();
        result.setId(user.getId());
        result.setData(user);
        return result;
    }

    @Override
    public ReqResult delete(User user) {
        user.setDeleteFlag(true);
        user.setDeleteTime(LocalDate.now());
        userMapper.updateById(user);
        ReqResult result = ReqResult.success();
        result.setData(user);
        return result;
    }

    @Override
    public ReqResult delete(List<String> ids) {
        userMapper.deleteBatchIds(ids);
        ReqResult result = ReqResult.success();
        result.setIds(ids);
        return result;
    }

}
