//package com.example.dto;
//
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//@Component
//public class JwtTokenUtil {
//
//    @Value("${jwt.secret}")
//    private String secret;
//
//    @Value("${jwt.expiration}")
//    private Long expiration;
//
//    public String generateToken(Long userId) {
//        Date now = new Date();
//        Date expiryDate = new Date(now.getTime() + expiration);
//
//        return Jwts.builder()
//                .setSubject(Long.toString(userId))
//                .setIssuedAt(now)
//                .setExpiration(expiryDate)
//                .signWith(SignatureAlgorithm.HS512, secret)
//                .compact();
//    }
//
//    // Other methods for token validation, extraction, etc.
//}
