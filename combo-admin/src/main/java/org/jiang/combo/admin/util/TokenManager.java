package org.jiang.combo.admin.util;

import io.jsonwebtoken.CompressionCodec;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * token 管理
 */
@Component
public class TokenManager {

    private int expireIn = 60 * 60 * 1000;

    private String secretKey = "123456";


//    public String generateToken(){
//        return null;
//    }
//
//    public String getUsernameFromToken() {
//        return null;
//    }
//
//    public boolean validToken(){
//        return false;
//    }

    /**
     * 根据用户信息生成 token
     */
    public String generateToken(String username) {
//        Map claims= new HashMap<>();
//        claims.put("username", username);
//        claims.put("userId", 12);
        String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expireIn))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();

        return token;
    }

    /**
     * 根据 token 生成用户信息
     */
    public String getUserInfo(String token) {
        String user = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody().getSubject();

        return user;
    }

    public void getSubject(String token) {
        System.out.println(Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody().get("userId"));
    }

    /**
     * 移除 token
     */
    public boolean removeToken(String token) {

        return false;
    }

    public static void main(String[] args) {
        TokenManager tokenManager = new TokenManager();
        String token = tokenManager.generateToken("user");
        System.out.println(token);
//        tokenManager.getSubject(tokenManager.createToken("username"));
    }
}
