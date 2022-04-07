package org.jiang.combo.admin.common;

import org.jiang.combo.admin.common.response.R;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

/**
 * 全局统一异常处理
 * org.zalando
 * problem-spring-web
 *
 * @ControllerAdvice
 * implements ProblemHandling
 *
 *  @ControllerAdvice
 *  SecurityAdviceTrait {}
 */
@RestControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R defalutException(HttpServletRequest req, Exception e) {
        System.out.println(e.getClass());
        return R.fail(500, "服务器异常", e.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R exception(HttpServletRequest req, Exception e) {
        return R.fail(422, "参数校验失败");
    }

//    @ResponseStatus(HttpStatus.OK)
//    @ExceptionHandler(Exception.class)
//    public Result system(HttpServletRequest req, Exception e) {
//        AllLoggers.EXCEPTION.error("RestExceptionHandler.system|servlet:{}|method:{}|code:{}|msg:{}",
//                req.getServletPath(),req.getMethod(), e.getMessage(), e);
//        return Result.error(ResultCode.BASE.SYSTEM_ERROR);
//    }
//
//    @ResponseStatus(HttpStatus.OK)
//    @ExceptionHandler(BusinessException.class)
//    public Result business(HttpServletRequest req, BusinessException e) {
//        AllLoggers.EXCEPTION.error("RestExceptionHandler.business|servlet:{}|method:{}|code:{}|msg:{}",
//                req.getServletPath(),req.getMethod(), e.getMessage(), e);
//        return Result.error(e.getErrorCode(), e.getErrorMessage());
//    }
}
