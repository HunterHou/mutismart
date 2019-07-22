package com.hd.mutismart.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.service.entity.User;
import com.hd.mutismart.service.mapper.UserMapper;
import com.hd.mutismart.service.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> query(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(user.getName())) {
            queryWrapper.like(User::getName, user.getName());
        }
        if (StringUtils.isNotBlank(user.getSex())) {
            queryWrapper.like(User::getSex, user.getSex());
        }
        if (user.getBirthday() != null && user != null) {
            queryWrapper.eq(User::getBirthday, user.getBirthday());
        }
        queryWrapper.eq(User::getDeleteFlag, user.getDeleteFlag());
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<User> queryPage(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(user.getName())) {
            queryWrapper.like(User::getName, user.getName());
        }
        if (StringUtils.isNotBlank(user.getSex())) {
            queryWrapper.like(User::getSex, user.getSex());
        }
        if (user.getBirthday() != null && user != null) {
            queryWrapper.eq(User::getBirthday, user.getBirthday());
        }
        queryWrapper.eq(User::getDeleteFlag, user.getDeleteFlag());
        queryWrapper.orderByDesc(User::getName);
        IPage<User> page = new Page<>(user.getPage(), user.getSize());
        user.setPage(null);
        user.setSize(null);
        return userMapper.selectPage(page, queryWrapper);
    }

    @Override
    public ReqResult insert(User user) {
        Wrapper<User> queryWrapper = new QueryWrapper<>(user);
        queryWrapper.getEntity().setName(user.getName());
        int count = userMapper.selectCount(queryWrapper);
        if (count > 0) {
            return ReqResult.fail("已存在");
        }
        user.setCreateTime(LocalDateTime.now());
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
        user.setDeleteTime(LocalDateTime.now());
        userMapper.updateById(user);
        ReqResult result = ReqResult.success();
        result.setData(user);
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
