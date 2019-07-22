package com.hd.mutismart.base.result;

import lombok.Data;

@Data
public class ReqResult {
    private Long id;
    private String code;
    private String message;
    private Object data;

    public ReqResult() {
    }

    public ReqResult(MessageCode messageCode) {
        this.code = messageCode.getCode();
        this.message = messageCode.getMessage();
    }

    public static ReqResult success() {
        return new ReqResult(MessageCode.SUCCESS);
    }

    public static ReqResult fail() {
        return new ReqResult(MessageCode.FAIL);
    }

}
