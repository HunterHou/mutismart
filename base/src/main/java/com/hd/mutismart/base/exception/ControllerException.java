package com.hd.mutismart.base.exception;

import com.hd.mutismart.base.result.ReqResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerException {

    @ExceptionHandler(Exception.class)
    public ReqResult commonResult(Exception ex) {
        log.error("执行失败", ex);
        return ReqResult.fail("系统异常");
    }


}
