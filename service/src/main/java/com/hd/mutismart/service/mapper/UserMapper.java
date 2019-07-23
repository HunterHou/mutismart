package com.hd.mutismart.service.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hd.mutismart.service.entity.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
