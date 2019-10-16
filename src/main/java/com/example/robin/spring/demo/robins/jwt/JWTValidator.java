package com.example.robin.spring.demo.robins.jwt;

import com.example.robin.spring.demo.robins.models.StudentModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JWTValidator {
    private String secret = "volvo";

    public StudentModel validate(String token) {

        StudentModel userModel = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            userModel = new StudentModel();

            userModel.setUsername(body.getSubject());
            userModel.setId(Long.parseLong((String) body.get("userId")));
            userModel.setRole((String) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return userModel;
    }
}
