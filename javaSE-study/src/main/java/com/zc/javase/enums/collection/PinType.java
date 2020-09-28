package com.zc.javase.enums.collection;

/**
 * @author zhao.cheng
 * @date 2020/9/8 14:39
 */
public enum  PinType {

    REGISTER(100000,"注册使用"),

    FORGET_PASSWORD(100001,"忘记密码使用"),

    UPDATE_PHONE_NUMBER(100002,"更新手机号码使用");

    private final int code;
    private final String message;

    PinType(int code,String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "PinType{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
