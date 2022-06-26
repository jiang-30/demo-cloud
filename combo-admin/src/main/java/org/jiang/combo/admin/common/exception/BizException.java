package org.jiang.combo.admin.common.exception;

import lombok.Getter;
import org.jiang.combo.admin.common.enums.ResultCode;

/**
 * 业务异常，请求用户需要处理
 */
@Getter
public class BizException extends RuntimeException {
    private ResultCode resultCode;

    public BizException(ResultCode resultCode) {
        super(resultCode.getMsg());
        this.resultCode = resultCode;
    }

    public BizException(ResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    public BizException(String message) {
        super(message);
        this.resultCode = ResultCode.BIZ_ERROR;
    }
}
