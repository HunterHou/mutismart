package com.hd.mutismart.base.result;

import java.util.List;

import lombok.Data;

/**
 * @author hunter
 */
@Data
public class ReqResult {

    private Boolean    success = true;
    private Long       id;
    private List<Long> ids;
    private String     code;
    private String     message;
    private Object     data;

    public ReqResult(){
    }

    public ReqResult(MessageCode messageCode){
        this.code = messageCode.getCode();
        this.message = messageCode.getMessage();
        this.success = messageCode.getSuccess();
    }

    public static ReqResult success() {
        return new ReqResult(MessageCode.SUCCESS);
    }

    public static ReqResult success(Object data) {
        return new ReqResult(MessageCode.SUCCESS).setData(data);
    }

    public static ReqResult fail() {
        return new ReqResult(MessageCode.FAIL);
    }

    public static ReqResult fail(String message) {
        ReqResult reqResult = ReqResult.fail();
        reqResult.setMessage(message);
        return reqResult;
    }

    public ReqResult setData(Object data) {
        this.data = data;
        return this;
    }

    @Override
    public String toString() {
        return "ReqResult{" + "success=" + success + ", code='" + code + '\'' + ", message='" + message + '\'' + '}';
    }
}
