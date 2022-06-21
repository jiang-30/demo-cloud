package org.jiang.combo.admin.common.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.jiang.combo.admin.common.utils.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * RestControllerAdvice可以通过 basePackages={"com.aa.admin"} 配置对那个包下的Controller 进行处理
 */
@RestControllerAdvice(basePackages = {"org.jiang.combo.admin.controller"})
public class ResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        if(returnType.toString().contains("swaggerResources") || returnType.toString().contains("getDocumentation")) {
            return  false;
        }
        // response是ResultVo类型，或者注释了NotControllerResponseAdvice都不进行包装
        if(returnType.getParameterType().isAssignableFrom(Result.class)) {
            return false;
        }


        // 控制器上添加 NotControllerResponseAdvide注解，使用hasMethodAnnotation 匹配， return false 忽略处理
//        returnType.hasMethodAnnotation()
        return true;
    }

    @SneakyThrows
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
//        if(body instanceof String) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            return  objectMapper.writeValueAsString(Result.success(body));
//        }
        // String类型不能直接包装
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在ResultVo里后转换为json串进行返回
                return objectMapper.writeValueAsString(Result.success(body));
            } catch (JsonProcessingException e) {

//                throw new APIException(ResultCode.RESPONSE_PACK_ERROR, e.getMessage());
            }
        }

//        if(body instanceof Result) {
//            return  body;
//        }

        return Result.success(body);

//        // String类型不能直接包装
//        if (returnType.getGenericParameterType().equals(String.class)) {
//            ObjectMapper objectMapper = new ObjectMapper();
//            try {
//                // 将数据包装在ResultVo里后转换为json串进行返回
//                return objectMapper.writeValueAsString(new ResultVo(data));
//            } catch (JsonProcessingException e) {
//                throw new APIException(ResultCode.RESPONSE_PACK_ERROR, e.getMessage());
//            }
//        }
//        // 否则直接包装成ResultVo返回
//        return new ResultVo(data);
    }

}
