package com.hd.mutismart.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.hd.mutismart.base.param.BasePageParam;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author hunter
 */
@Data
public class User extends BasePageParam {

    @TableId(type = IdType.UUID)
    private String id;
    private String name;
    private Boolean deleteFlag = false;
    private LocalDate birthday;
    private String sex;
    private LocalDateTime createTime;
    private LocalDateTime deleteTime;
}
