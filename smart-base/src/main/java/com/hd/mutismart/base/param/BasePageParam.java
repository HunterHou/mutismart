package com.hd.mutismart.base.param;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;

/**
 * @author hunter
 */
@Data
public class BasePageParam<T> implements Serializable {

    @TableField(exist = false)
    Integer page;
    @TableField(exist = false)
    Integer size;
}
