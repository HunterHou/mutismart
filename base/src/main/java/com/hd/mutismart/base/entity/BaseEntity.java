package com.hd.mutismart.base.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BaseEntity implements Serializable {

    LocalDateTime readTime = LocalDateTime.now();
}
