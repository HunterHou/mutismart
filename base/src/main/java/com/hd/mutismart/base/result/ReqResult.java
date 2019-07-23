package com.hd.mutismart.base.result;

import java.util.List;

import lombok.Data;

/**
 * @author hunter
 */
@Data
public class ReqResult {

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
    }

    public static ReqResult success() {
        return new ReqResult(MessageCode.SUCCESS);
    }

    public static ReqResult fail() {
        return new ReqResult(MessageCode.FAIL);
    }

    public static ReqResult fail(String message) {
        ReqResult reqResult = ReqResult.fail();
        reqResult.setMessage(message);
        return reqResult;
    }

}
