package com.hd.mutismart.base.result;

import lombok.Data;

import java.util.List;

/**
 * 通用返回参数
 * 
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

    public static ReqResult success(List<Long> ids) {
        return ReqResult.success().setIds(ids);
    }

    public static ReqResult success(Object data) {
        return ReqResult.success().setData(data);
    }

    public static ReqResult success(Long id, Object data) {
        return ReqResult.success().setData(data).setId(id);
    }

    public static ReqResult fail() {
        return new ReqResult(MessageCode.FAIL);
    }

    public static ReqResult fail(String message) {
        return ReqResult.fail().setMessage(message);
    }

    public ReqResult setId(Long id) {
        this.id = id;
        return this;
    }

    public ReqResult setIds(List<Long> ids) {
        this.ids = ids;
        return this;
    }

    public ReqResult setData(Object data) {
        this.data = data;
        return this;
    }

    public ReqResult setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "ReqResult{" + "success=" + success + ", code='" + code + '\'' + ", message='" + message + '\'' + '}';
    }
}
