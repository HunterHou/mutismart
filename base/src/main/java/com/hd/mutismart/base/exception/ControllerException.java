package com.hd.mutismart.base.exception;

import com.hd.mutismart.base.result.ReqResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler(Exception.class)
    public ReqResult commonResult() {
        return ReqResult.fail("系统异常");
    }
}
