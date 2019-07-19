package com.ems.bean;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;

@ConfigurationProperties(prefix = "jwt")
@Data
public class Jwt {

    /**
     * 凭证
     */
    private String authtication;

    /**
     * 过期时间
     */
    private long expire;
    /**
     * 加密密钥
     */
    private String secret;

    public String authtication(String userId) {
        return Jwts.builder().setHeaderParam("typ", "JWT")
                .setSubject(userId)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expire * 1000))
                .signWith(SignatureAlgorithm.HS256, secret).compact();
    }


    public Claims getClaims(String authtication) {
        try {
            return Jwts.parser().setSigningKey(secret).parseClaimsJws(authtication).getBody();
        } catch (Exception e) {
            return null;
        }
    }


    public boolean expired(Date expiration) {
        return expiration.before(new Date());
    }

}
