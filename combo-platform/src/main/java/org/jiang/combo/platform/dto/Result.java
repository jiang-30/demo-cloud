package org.jiang.combo.platform.dto;

import lombok.Data;

@Data
public class Result<T> {
    private int code;
    private String message;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<T>();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(data);

        return result;
    }

    public static <T> Result<T> fail(Exception e) {
        Result<T> result = new Result<T>();
        result.setCode(500);
        result.setMessage(e.getMessage());
        result.setData((T) e);

        return result;
    }
}
