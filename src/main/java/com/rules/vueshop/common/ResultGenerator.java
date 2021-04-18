package com.rules.vueshop.common;

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result genSuccessResult() {
        return new Result()
                .setStatus(ResultStatusEnum.SUCCESS.getStatus())
                .setCode(ResultStatusEnum.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE);
    }

    public static <T> Result<T> genSuccessResult(T data) {
        return new Result()
                .setStatus(ResultStatusEnum.SUCCESS.getStatus())
                .setCode(ResultStatusEnum.SUCCESS)
                .setMessage(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(ResultStatusEnum code, String message) {
        return new Result()
            .setStatus(code.getStatus())
            .setCode(code)
            .setMessage(message);
    }

    public static Result genFailResult(String message) {
        return new Result()
                .setStatus(ResultStatusEnum.FAIL.getStatus())
                .setCode(ResultStatusEnum.FAIL)
                .setMessage(message);
    }

    public static Result genAccessDeniedFailResult(String message) {
        return new Result()
            .setStatus(ResultStatusEnum.UNAUTHORIZED.getStatus())
            .setCode(ResultStatusEnum.UNAUTHORIZED)
            .setMessage(message);
    }
}
