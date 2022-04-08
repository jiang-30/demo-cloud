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
    public static  long expireIn = 60 * 60 * 1000;
    private static String accessSecretKey = "123456";
    private static String refreshSecretKey = "654321";

    /**
     * 生成访问token
     */
    public static String generateAccessToken(String subject) {
        return generateToken(subject, expireIn, accessSecretKey);
    }

    /**
     * 访问token获取 subject
     */
    public static String getAccessSubject(String token) throws Exception {
        String subject = getSubject(token, accessSecretKey);

        return subject;
    }

    /**
     * 生成刷新token
     */
    public static String generateRefreshToken(String subject) {
        return generateToken(subject,expireIn * 4, refreshSecretKey);
    }

    /**
     * 刷新刷新token获取 subject
     */
    public static String getRefreshSubject(String token) throws Exception {
        String subject = getSubject(token, refreshSecretKey);

        return subject;
    }

    /**
     * 根据主题生成 token
     */
    public static String generateToken(String subject, long exp, String secretKey) {

        String token = Jwts.builder()
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + exp))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();

        return token;
    }

    /**
     * 获取主题
     */
    public static String getSubject(String token, String secretKey) {
        String subject = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody().getSubject();

        return subject;
    }
}
