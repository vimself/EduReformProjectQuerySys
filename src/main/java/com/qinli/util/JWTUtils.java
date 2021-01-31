package com.qinli.util;


import com.qinli.pojo.User;

import java.util.Calendar;
import java.util.Map;

/**
 * @author supermantx
 * @time 2021/1/28 15:37
 * JWT的工具类
 */
public class JWTUtils {

    private final static String SING = "@$%^!!@&#";

    /**
     * 根据用户的姓名生成token
     * 不太行的版本
     * @return
     */
    @Deprecated
    public static String getToken(User user){
        // 设置过期时间
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 3); // 三天过期
        String token = JWT.create().withClaim("username", user.getUsername())
                .withExpiresAt(c.getTime())
                .sign(Algorithm.HMAC256(SING));
        return token;
    }


    /**
     * 改进版,根据传入的map对象制造token
     * @param map
     * @return
     */
    public static String getToken(Map<String, String> map){
        // 传入map时的token生成(lamda语法)

        JWTCreator.Builder builder = JWT.create();
        map.forEach((k, v)->{
            builder.withClaim(k, v);
        });
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 3); // 三天后token过期
        String token = builder.withExpiresAt(c.getTime()).sign(Algorithm.HMAC256(SING));
        return token;
    }

    /**
     * 验证token,并返回一个能够分析token的对象
     * @param token
     */
    public static DecodedJWT verify(String token) throws Exception{
        return JWT.require(Algorithm.HMAC256(SING)).build().verify(token);
    }

}
