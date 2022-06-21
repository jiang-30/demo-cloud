package org.jiang.combo.admin.common.utils;

import lombok.Getter;

@Getter
public class BIZException extends RuntimeException{
    private int code;
    private String message;

    public BIZException(ResultCode resultCode, String message) {
        super(message);
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public BIZException(String message) {
        super(message);
        this.code = ResultCode.BIZ_ERROR.getCode();
        this.message = ResultCode.BIZ_ERROR.getMessage();
    }
}
