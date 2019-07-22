package com.hd.mutismart.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hd.mutismart.base.result.ReqResult;
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
        Wrapper<User> queryWrapper = new QueryWrapper<User>();
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public ReqResult insert(User user) {
        userMapper.insert(user);
        ReqResult result = ReqResult.success();
        result.setId(user.getId());
        return result;
    }

    @Override
    public ReqResult update(User user) {
        userMapper.updateById(user);
        ReqResult result = ReqResult.success();
        result.setId(user.getId());
        return result;
    }

    @Override
    public ReqResult delete(Long id) {
        userMapper.deleteById(id);
        ReqResult result = ReqResult.success();
        result.setId(id);
        return result;
    }

    @Override
    public ReqResult delete(List<Long> ids) {
        userMapper.deleteBatchIds(ids);
        ReqResult result = ReqResult.success();
        result.setIds(ids);
        return result;
    }

}
