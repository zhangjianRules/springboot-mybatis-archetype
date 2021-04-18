package com.rules.vueshop.common;

import java.util.stream.Stream;

public enum ResultStatusEnum {

    SUCCESS(200, "success", "成功"),
    FAIL(400, "failed", "失败"),
    UNAUTHORIZED(401, "failed", "未认证"),
    NOT_FOUND(404, "failed", "接口不存在"),
    EXPECTATION_FAILED(417, "failed", "异常"),
    INTERNAL_SERVER_ERROR(500, "failed", "内部服务器错误");

    private final Integer code;
    private final String status;
    private final String describe;

    ResultStatusEnum(int code, String status, String describe) {
        this.code = code;
        this.status = status;
        this.describe = describe;
    }

    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getDescribe() {
        return describe;
    }

    public static ResultStatusEnum getByCode(Integer code) {
        return Stream.of(ResultStatusEnum.values())
            .filter(c -> c.getCode().equals(code))
            .findFirst()
            .orElse(null);
    }

    public static ResultStatusEnum getByValue(String property) {
        return Stream.of(ResultStatusEnum.values())
            .filter(c -> c.getStatus().equals(property))
            .findFirst()
            .orElse(null);
    }

    public int code() {
        return code;
    }
}