package com.hd.mutismart.service.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hd.mutismart.base.result.ReqResult;
import com.hd.mutismart.service.entity.User;
import com.hd.mutismart.service.mapper.UserMapper;
import com.hd.mutismart.service.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> query(User user) {
        if (user == null) {
            user = new User();
        }
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
        if (queryWrapper.getExpression().getOrderBy().isEmpty()) {
            queryWrapper.orderByDesc(User::getId);
        }

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
        if (queryWrapper.getExpression().getOrderBy().isEmpty()) {
            queryWrapper.orderByDesc(User::getId);
        }
        IPage<User> page = new Page<>(user.getPage(), user.getSize());
        user.setPage(null);
        user.setSize(null);
        return userMapper.selectPage(page, queryWrapper);
    }

    private ReqResult checkName(User user) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getName, user.getName());
        List<User> users = userMapper.selectList(queryWrapper);
        if (users.size() == 0) {
            return ReqResult.success();
        }
        if (user.getId() == null) {
            return ReqResult.fail("名称已存在");
        }
        for (User user1 : users) {
            if (!user.getId().equals(user1.getId())) {
                return ReqResult.fail("名称已存在");
            }
        }
        return ReqResult.success();
    }

    @Override
    public ReqResult insert(User user) {
        ReqResult check = checkName(user);
        if (!check.getSuccess()) {
            return check;
        }
        user.setCreateTime(LocalDateTime.now());
        user.setDeleteFlag(false);
        userMapper.insert(user);
        return ReqResult.success(user.getId(), user);
    }

    @Override
    public ReqResult update(User user) {
        ReqResult check = checkName(user);
        if (!check.getSuccess()) {
            return check;
        }
        userMapper.updateById(user);
        return ReqResult.success(user.getId(), user);
    }

    @Override
    public ReqResult delete(User user) {
        user.setDeleteFlag(true);
        user.setDeleteTime(LocalDateTime.now());
        userMapper.updateById(user);
        return ReqResult.success(user.getId(), user);
    }

    @Override
    public ReqResult delete(List<Long> ids) {
        userMapper.deleteBatchIds(ids);
        return ReqResult.success(ids);
    }

}
