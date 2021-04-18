package com.rules.vueshop.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

public class TokenTest {
    /**
     * JWT 原理
     * JWT 分成三个部分，header, payload, sign
     * 其中header 和 payload 保存用户信息，
     * sign 用于验证header 和 payload 是否被篡改
     *      sign server会生成私钥对header 和 payload 进行签名
     * token 只是用于client和server的一个凭证， server 无需保存， 具有更好的扩展性
     * token 与 session 和 cookie 优缺点对比 请参考：https://cloud.tencent.com/developer/article/1460770
     */

    private String key = "token!Q2W#E$RW";

    @Test
    public void testTokenGenerate(){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 900);
        String token = JWT.create()
            .withClaim("username", "rules")
            .withClaim("password", "123456")
            .withExpiresAt(instance.getTime())
            .sign(Algorithm.HMAC256(key));
        System.out.println(token);
    }

    @Test
    public void testTokenValidate(){
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(key)).build();
        DecodedJWT decodedJWT = jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsImV4cCI6MTYxODcxNzEwMiwidXNlcm5hbWUiOiJydWxlcyJ9.pmU_rCo6SWDTQWu6nRnU2FfA3e6OBE8geqlUktI0Txk");

            System.out.println("username: " + decodedJWT.getClaim("username").asString());
        System.out.println("password: " + decodedJWT.getClaim("password").asString());
        System.out.println("expire: " + decodedJWT.getExpiresAt());

    }
}
