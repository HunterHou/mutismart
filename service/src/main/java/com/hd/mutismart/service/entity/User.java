package com.hd.mutismart.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDate;

/**
 * @author hunter
 */
@Data
public class User {
    @TableId(type = IdType.UUID)
    private String id;
    private String name;
    private Boolean deleteFlag;
    private LocalDate birthday;
    private String sex;
    private LocalDate createTime;
    private LocalDate deleteTime;
}
