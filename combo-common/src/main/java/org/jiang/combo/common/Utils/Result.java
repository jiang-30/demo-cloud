package org.jiang.combo.common.Utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

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
