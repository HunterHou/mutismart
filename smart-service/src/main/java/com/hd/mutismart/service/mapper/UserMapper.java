package com.hd.mutismart.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hd.mutismart.service.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
