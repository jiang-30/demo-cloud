package org.jiang.combo.admin.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Result<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 响应数据
     */
    private T data;


    /**
     * 成功
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(1);
        result.setMessage("成功");
        return result;
    }
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setCode(1);
        result.setMessage("成功");
        result.setData(data);

        return result;
    }

    public static void response(HttpServletResponse response, String str) throws IOException {
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().println(str);
    }


    /**
     * 失败
     */
    public static Result fail(int code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);

        return result;
    }
    public static <T> Result<T> fail(int code, String message, T data) {
        Result<T> result = new Result<T>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);

        return result;
    }

}
