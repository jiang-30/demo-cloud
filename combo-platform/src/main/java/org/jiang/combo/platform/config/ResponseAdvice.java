package org.jiang.combo.platform.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jiang.combo.common.response.R;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.validation.ValidationException;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if(body instanceof String) {
            ObjectMapper objectMapper = new ObjectMapper();
            return  objectMapper.writeValueAsString(R.success(body));
        }

        if(body instanceof  R) {
            return  body;
        }

        return R.success(body);
    }

    /**
     * 全局统一异常处理
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R exception(Exception e) {
        if( e instanceof ValidationException) {
            return R.fail(422, "参数校验失败", e);
        }
        return R.fail(500, "服务器异常", e);
    }

}
