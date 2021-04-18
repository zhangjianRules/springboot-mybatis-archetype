package com.rules.vueshop.advice;

import com.rules.vueshop.common.Result;
import com.rules.vueshop.common.ResultStatusEnum;
import com.rules.vueshop.exceptions.AuthorizedException;
import com.rules.vueshop.exceptions.HintException;
import com.rules.vueshop.util.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
@Order
public class GlobalResponseHandler implements ResponseBodyAdvice<Result<?>> {
    private static final Logger logger = LoggerFactory.getLogger(GlobalResponseHandler.class);

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getParameterType().isAssignableFrom(Result.class);
    }

    @Override
    public Result<?> beforeBodyWrite(Result<?> body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return body;
    }

    @ExceptionHandler
    public Result authorizedException(AuthorizedException e) {
        logger.error("authorized exception {}", ExceptionUtils.stringifyException(e));
        return new Result()
            .setCode(ResultStatusEnum.UNAUTHORIZED)
            .setMessage(e.getMessage());
    }

    @ExceptionHandler
    public Result HintException(HintException e) {
        logger.error("validation exception {}", ExceptionUtils.stringifyException(e));
        return new Result()
            .setStatus(ResultStatusEnum.EXPECTATION_FAILED.getStatus())
            .setCode(ResultStatusEnum.EXPECTATION_FAILED)
            .setMessage(e.getMessage());
    }

}
