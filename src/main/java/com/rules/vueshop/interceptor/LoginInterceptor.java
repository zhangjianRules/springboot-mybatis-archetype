package com.rules.vueshop.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rules.vueshop.common.ResultStatusEnum;
import com.rules.vueshop.util.TokenUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Map<Object, Object> map = new HashMap<>();
        //获取请求头中令牌
        String token = request.getHeader("Authorization");
        if (StringUtils.isBlank(token)) {
            map.put("message", "token 不存在");
            buildResponseHintException(response, map);
            return false;
        }
        try {
            // 验证令牌
            TokenUtil.verify(token);
            return true;
        } catch (SignatureVerificationException e) {
            e.printStackTrace();
            map.put("message", "无效签名！");
        } catch (TokenExpiredException e) {
            e.printStackTrace();
            map.put("message", "token过期！");
        } catch (AlgorithmMismatchException e) {
            e.printStackTrace();
            map.put("message", "token算法不一致！");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("msg", "token无效！！！");
        }
        buildResponseHintException(response, map);
        return false;
    }

    private void buildResponseHintException(HttpServletResponse response, Map<Object, Object> map) throws IOException {
        map.put("code", ResultStatusEnum.UNAUTHORIZED.code());
        //设置状态
        map.put("state", false);
        //将map 转为json
        String json = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(json);
    }
}
