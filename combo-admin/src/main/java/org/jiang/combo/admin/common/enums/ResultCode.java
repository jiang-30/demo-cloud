package org.jiang.combo.admin.common.enums;

import lombok.Getter;

// * 1** ：服务器接收到请求，需要请求者继续执行操作
// * 2** ：成功，操作被成功接收并处理
// * 3** ：重定向，需要进一步操作以完成请求
// * 4** ：客户端错误，请求包含语法错误或无法完成请求
// * 5** ：服务器错误，服务器在处理请求的过程中发生了错误

/**
 * 自定义响应状态码
 */
@Getter
public enum ResultCode {
    SUCCESS(1, "成功"),

    PARAM_ERROR(41000, "请求参数异常"),
    PARAM_IS_INVALID(41001, "请求参数无效"),
    PARAM_IS_BLANK(41002, "请求参数为空"),
    PARAM_TYPE_ERROR(41003, "请求参数类型错误"),
    PARAM_NOT_COMPLETE(41004, "请求参数缺失"),

    USER_ERROR(42000, "用户异常"),
    USER_NOT_LOGIN(42001, "用户未登录，请登录"),
    USER_NOT_AUTH(42006, "用户未授权"),
    USER_LOGIN_ERROR(42002, "帐号不存在或者密码错误"),
    USER_ACCOUNT_FORBINDDEN(42003, "帐号已被禁用"),
    USER_NOT_EXIST(42004, "用户不存在"),
    USER_HAS_EXISTED(42005, "用户已存在"),

    BIZ_ERROR(45001, "业务异常"),

    SERVER_ERROR(50000, "服务器内部错误");

    private int code;
    private String msg;

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
