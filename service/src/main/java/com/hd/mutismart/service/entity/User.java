package com.hd.mutismart.service.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import com.hd.mutismart.base.param.BasePageParam;

import lombok.Data;

/**
 * @author hunter
 */
@Data
public class User extends BasePageParam {

    @TableId(type = IdType.AUTO)
    private Long          id;
    private String        name;
    private Boolean       deleteFlag = false;
    private LocalDate     birthday;
    private String        sex;
    private LocalDateTime createTime;
    private LocalDateTime deleteTime;
    @Version
    private Long          version;
}
