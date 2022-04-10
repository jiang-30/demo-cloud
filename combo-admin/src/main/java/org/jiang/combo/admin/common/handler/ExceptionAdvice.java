package org.jiang.combo.admin.common.handler;

import org.jiang.combo.admin.common.utils.Result;
import org.springframework.http.HttpStatus;
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
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.OK)
    public Result defalutException(HttpServletRequest req, Exception e) {
        System.out.println("defalutException: " + e.getClass());
        return Result.fail(500, e.getMessage(), e);
    }
}
