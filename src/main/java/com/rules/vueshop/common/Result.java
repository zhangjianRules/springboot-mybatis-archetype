package com.rules.vueshop.common;


/**
 * 统一API响应结果封装
 */
public class Result<T> {
    private int code;
    private String message;
    private String status;
    private T data;

    public Result setCode(ResultStatusEnum resultStatusEnum) {
        this.code = resultStatusEnum.code();
        return this;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Result setStatus(String status) {
        this.status = status;
        return this;
    }
}
