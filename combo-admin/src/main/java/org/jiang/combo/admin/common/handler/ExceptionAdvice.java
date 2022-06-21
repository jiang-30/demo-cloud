package org.jiang.combo.admin.common.handler;

import org.jiang.combo.admin.common.utils.BIZException;
import org.jiang.combo.admin.common.utils.Result;
import org.jiang.combo.admin.common.utils.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

/**
 * 全局统一异常处理
 * org.zalando
 * problem-spring-web
 * RestControllerAdvice
 */
@ControllerAdvice
public class ExceptionAdvice {

    /**
     * 参数校验失败
     */
    @ExceptionHandler(BindException.class)
    public Result validateExcepton(BindException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return Result.fail(ResultCode.PARAM_IS_INVALID, objectError.getDefaultMessage());
    }

    /**
     * 业务逻辑错误
     */
    @ExceptionHandler(BIZException.class)
    public Result bizExceptionHandler(BIZException e) {
        return Result.fail(e.getCode(), e.getMessage());
    }

    /**
     * 其他错误
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Result defalutException(HttpServletRequest req, Exception e) {
        System.out.println("defalutException: " + e.getClass());
        return Result.fail(500, e.getMessage(), e);
    }
}
