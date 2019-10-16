package com.example.robin.spring.demo.robins.jwt;

import com.example.robin.spring.demo.robins.models.StudentModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

@Component
public class JWTGenerator {
    public String generate(StudentModel userModel) {


        Claims claims = Jwts.claims().setSubject(userModel.getUserName());
        claims.put("userId", String.valueOf(userModel.getId()));
        claims.put("role", userModel.getRole());

        return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS512, "volvo").compact();
    }
}
