package com.kim.dani.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;


@Component
public class JwtTokenValidator {

    @Value("${jwt.secret}")
    private static String jwtSecret;


    public static Claims jwtValidation(String token) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(jwtSecret.getBytes(StandardCharsets.UTF_8))
                    .parseClaimsJws(token)
                    .getBody();
            return claims;
        } catch (JwtException e) {
            return null;
        }
    }

    public String jwtGetUserId(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies == null) {
            return "Unauthorized1";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("jwt")) {
                String token = cookie.getValue();
                System.out.println(token+"%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                Claims claims = jwtValidation(token);
                String userid = claims.get("id", String.class);
                return userid;
            }
        }
        return "Unauthorized2";
    }



}