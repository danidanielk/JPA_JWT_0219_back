package com.kim.dani.jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;


    public String generateToken(String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() );

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .claim("id","23")
                .claim("email",email)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String setTokenCookie(HttpServletResponse res,String email){
//        JwtTokenProvider jwtTokenProvider = new JwtTokenProvider();
        String token = generateToken(email);
        System.out.println(token+"===========================");
        Cookie cookie = new Cookie("jwt", token);
        cookie.setMaxAge(60*1);
        cookie.setHttpOnly(true); // Xss 방어
        cookie.setPath("/");
        res.addCookie(cookie);
        return token;

    }
}