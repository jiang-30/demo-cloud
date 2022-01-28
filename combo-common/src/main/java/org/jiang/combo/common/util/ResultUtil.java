package org.jiang.combo.common.util;

import lombok.Data;

@Data
public class ResultUtil<T> {
    private int code;
    private String message;
    private T data;

    public static <T> ResultUtil<T> success(T data) {
        ResultUtil<T> result = new ResultUtil<T>();
        result.setCode(200);
        result.setMessage("成功");
        result.setData(data);

        return result;
    }

    public static <T> ResultUtil<T> fail(Exception e) {
        ResultUtil<T> result = new ResultUtil<T>();
        result.setCode(500);
        result.setMessage(e.getMessage());
        result.setData((T) e);

        return result;
    }
}
