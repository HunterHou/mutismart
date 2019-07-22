package com.hd.mutismart.base.result;

import lombok.Data;

@Data
public class ReqResult {
    private Long id;
    private String code;
    private String message;
    private Object data;
}
