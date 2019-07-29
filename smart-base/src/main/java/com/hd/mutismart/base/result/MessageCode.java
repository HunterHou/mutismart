package com.hd.mutismart.base.result;

/**
 * @author hunter
 */

public enum MessageCode {
                         SUCCESS(200, "成功", true), FAIL(400, "失败", false);

    private Integer code;
    private String  message;
    private Boolean success;

    MessageCode(Integer code, String message, Boolean success){
        this.code = code;
        this.message = message;
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Boolean getSuccess() {
        return success;
    }
}
