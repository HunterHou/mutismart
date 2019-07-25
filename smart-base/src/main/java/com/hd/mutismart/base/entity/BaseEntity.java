package com.hd.mutismart.base.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class BaseEntity implements Serializable {

    LocalDateTime readTime = LocalDateTime.now();
}
