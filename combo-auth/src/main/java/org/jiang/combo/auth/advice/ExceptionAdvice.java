package org.jiang.combo.auth.advice;

import org.jiang.combo.common.response.R;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

/**
 * 全局统一异常处理
 */
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R defalutException(HttpServletRequest req, Exception e) {
        return R.fail(500, "服务器异常", e);
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R exception(HttpServletRequest req, Exception e) {
        return R.fail(422, "参数校验失败", e);
    }
}
