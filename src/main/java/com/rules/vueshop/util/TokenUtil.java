package com.rules.vueshop.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;

import java.util.Calendar;
import java.util.Map;

public class TokenUtil {
    private static final String key = "token!Q2W#E$RW";

    public static String getToken(Map<String, String> map) {
        Calendar instance = Calendar.getInstance();
        // 默认7天过期
        instance.add(Calendar.DATE, 7);
        // 创建jwt  builder
        JWTCreator.Builder builder = JWT.create();
        // payload
        map.forEach((k, v) -> {
            builder.withClaim(k, v);
        });
        // token 过期时间 和 sign
        String token = builder.withExpiresAt(instance.getTime())
            .sign(Algorithm.HMAC256(key));
        return token;
    }

    public static void verify(String token) {
        JWT.require(Algorithm.HMAC256(key)).build().verify(token);
    }

    public static DecodedJWT getTokenInfo(String token){
        return JWT.require(Algorithm.HMAC256(key)).build().verify(token);
    }
}
