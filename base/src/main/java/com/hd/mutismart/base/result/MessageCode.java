package com.hd.mutismart.base.result;

/**
 * @author hunter
 */

public enum MessageCode {
                         SUCCESS("200", "成功"), FAIL("400", "失败");

    private String code;
    private String message;

    MessageCode(String code, String message){
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
