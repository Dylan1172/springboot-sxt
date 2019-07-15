package org.jit.sose.enums;

/**
 * 统一返回对象的状态码枚举类型
 *
 * @Author Dylan.W
 * @Date 2019/7/15 14:06
 */
public enum ResponseEnum {

    /**
     * 请求成功。一般用于GET与POST请求
     */
    SUCCESS(200, "success"),

    DATA_FORMAT_ERROR(420, "data format error"),

    ERROR(500, "error"),

    ALIPAY_ERROR(567, "alipay error");

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回信息
     */
    private String msg;

    ResponseEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
