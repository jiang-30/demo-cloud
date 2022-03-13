package org.jiang.combo.common.response;

import lombok.Data;

@Data
public class R<T> {
//    private boolean success;
    private int code;
    private String message;
    private T data;

    private R() {}

    // ok
    public static <T> R<T> success(T data) {
        R<T> result = new R<T>();
//        result.setSuccess(true);
        result.setCode(200);
        result.setMessage("成功");
        result.setData(data);

        return result;
    }

    public static <T> R<T> fail(int code, String message, T data) {
        R<T> result = new R<T>();
//        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);

        return result;
    }
}
