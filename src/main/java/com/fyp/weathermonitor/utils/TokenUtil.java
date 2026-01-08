package com.fyp.weathermonitor.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fyp.weathermonitor.entity.vo.tokenVO;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {

    //过期时间
    private static final long EXPIRE_DATE= 1000 * 60 * 30;

    //refreshtoken过期时间
    private static final long REFRESH_EXPIRE_DATE= 1000 * 60 * 60 * 3;

    //token秘钥
    private static final String TOKEN_SECRET = "ZCEQIUBFKSJBFJH2020BQWE";



    public static tokenVO createToken(String username, String nickname){
        String token = "";
        String refreshToken = "";
        tokenVO tokenvo = new tokenVO();
        try {
            //过期时间
            Long date = System.currentTimeMillis()+EXPIRE_DATE;
            Long refreshDate = System.currentTimeMillis()+REFRESH_EXPIRE_DATE;
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",username)
                    .withExpiresAt(new Date(date))
                    .sign(algorithm);

            refreshToken = JWT.create()
                    .withHeader(header)
                    .withClaim("username",username)
                    .withExpiresAt(new Date(refreshDate))
                    .sign(algorithm);
            tokenvo.setAccessToken(token);
            tokenvo.setExpires(refreshDate);
            tokenvo.setRefreshToken(refreshToken);
            tokenvo.setUsername(username);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return tokenvo;
    }

    public static tokenVO refreshToken(String refreshToken){
        tokenVO tokenvo = new tokenVO();
        try {
            //过期时间
            Long date = System.currentTimeMillis()+EXPIRE_DATE;
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            String username = JWT.decode(refreshToken).getClaim("username").asString();
            //携带username，password信息，生成签名
            String token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",username)
                    .withExpiresAt(new Date(date))
                    .sign(algorithm);
            tokenvo.setAccessToken(token);
            tokenvo.setExpires(date);
            tokenvo.setRefreshToken(refreshToken);
            tokenvo.setUsername(username);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return tokenvo;
    }

    public static boolean verify(String token){
        /**
         * @desc   验证token，通过返回true
         * @params [token]需要校验的串
         **/
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }
}
