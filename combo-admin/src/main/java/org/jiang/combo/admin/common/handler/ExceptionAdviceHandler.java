package org.jiang.combo.admin.common.handler;

import org.jiang.combo.admin.common.exception.BizException;
import org.jiang.combo.admin.common.utils.Result;
import org.jiang.combo.admin.common.enums.ResultCode;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局统一异常处理
 * org.zalando
 * problem-spring-web
 * RestControllerAdvice
 */
@ControllerAdvice
public class ExceptionAdviceHandler {

    /**
     * 参数校验失败
     */
    @ResponseBody
    @ExceptionHandler(BindException.class)
    public Result validateException(BindException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return Result.fail(ResultCode.PARAM_ERROR, objectError.getDefaultMessage());
    }

    /**
     * 业务逻辑错误
     */
    @ResponseBody
    @ExceptionHandler(BizException.class)
    public Result bizExceptionHandler(BizException e) {
        return Result.fail(e.getResultCode(), e.getMessage());
    }

    /**
     * 其他错误
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result defalutException(HttpServletRequest req, Exception e) {
        System.out.println("defalutException: " + e.getClass());
        return Result.fail(ResultCode.SERVER_ERROR, e.getMessage());
    }
}
