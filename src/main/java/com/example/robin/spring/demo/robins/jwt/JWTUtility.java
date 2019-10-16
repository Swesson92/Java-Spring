package com.example.robin.spring.demo.robins.jwt;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;

import java.security.SignatureException;
import java.util.Date;

public class JWTUtility {

    public static final String TOKEN_PREFIX  = "Bearer ";

    private static final String SECRET = "Secret";

    public static final long   EXPIRATION_TIME  = 960_000;

    public static String parseUsername(String jwtToken) {
        try {
            return Jwts.parser()
                    .setSigningKey(SECRET.getBytes())
                    .parseClaimsJws(subToken(jwtToken))
                    .getBody()
                    .getSubject();
        } catch (ExpiredJwtException | MalformedJwtException e) {
            return null;
        }
    }


    /** Building methods */
    public static String buildJWTToken(String username_email,String role) {
        return Jwts.builder()
                .setSubject(username_email)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
                .compact();
    }


    /** Helping methods */
    private static String subToken(String token) {
        return token.replace(TOKEN_PREFIX, "");
    }
}
