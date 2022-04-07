package org.jiang.combo.admin.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    static public int expireIn = 60 * 60 * 1000;
    static private byte[] secretKey = "123456".getBytes();

    static public String generateAccessToken(Integer id) {
        String token = "";

        return token;
    }

    public String generateRefreshToken(String username) {
        String token = "";

        return token;
    }


    /**
     * 根据用户名生成 token
     */
    static public String generateToken(int id) {
        Map claims = new HashMap();
        claims.put("id", id);

        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expireIn))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();

        return token;
    }

    /**
     * 获取用户名
     */
    static public int getSubject(String token) {
        Claims body = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        return (int) body.get("id");
    }

    /**
     * 移除 token
     */
    public boolean removeToken(String token) {

        return false;
    }

}
