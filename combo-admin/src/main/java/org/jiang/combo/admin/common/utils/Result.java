package org.jiang.combo.admin.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.jiang.combo.admin.common.enums.ResultCode;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Result<T> {

    private Integer code;
    private String msg;
    private Object data; // Object


    /**
     * 成功
     */
    public static Result success() {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(null);

        return result;
    }

    public static Result success(Object data) {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMsg(ResultCode.SUCCESS.getMsg());
        result.setData(data);

        return result;
    }

    /**
     * 失败
     */
    public static Result fail(ResultCode resultCode) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
        result.setData(null);

        return result;
    }

    public static Result fail(ResultCode resultCode, Object data) {
        Result result = new Result();
        result.setCode(resultCode.getCode());
        result.setMsg(resultCode.getMsg());
        result.setData(data);

        return result;
    }

//    public static Result fail(int code, String msg) {
//        Result result = new Result();
//        result.setCode(code);
//        result.setMsg(msg);
//        result.setData(null);
//
//        return result;
//    }
//
//    public static  Result fail(int code, String msg, Object data) {
//        Result result = new Result();
//        result.setCode(code);
//        result.setMsg(msg);
//        result.setData(data);
//
//        return result;
//    }

    /**
     * 响应
     */
    public static void response(HttpServletResponse response, String str) throws IOException {
        response.setStatus(200);
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        response.getWriter().println(str);
    }


}
