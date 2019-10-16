package com.example.robin.spring.demo.robins.jwt;

import com.example.robin.spring.demo.robins.entities.Student;
import com.example.robin.spring.demo.robins.models.LoginModel;
import com.example.robin.spring.demo.robins.services.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JWTAuthenticationFilter {
    public static final String TOKEN_PREFIX     = "Bearer ";
    public static final String HEADER_STRING    = "Authorization";

    private final AuthenticationManager authenticationManager;
    private final StudentService userService;


    @Autowired
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager, ApplicationContext ctx) {
        this.userService = ctx.getBean(StudentService.class);
        this.authenticationManager = authenticationManager;
    }

    public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws AuthenticationException {
        System.out.println("attemptAuthentication");
        try {
            LoginModel login = new ObjectMapper().readValue(
                    req.getInputStream(),LoginModel.class);
            req.getInputStream().close();

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            login.getUsername(),
                            login.getPassword()
                    )
            );

        } catch (BadCredentialsException | InternalAuthenticationServiceException | IOException e) {
            System.out.println("error");
            e.printStackTrace();
        }
        return null;
    }


    protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain, Authentication auth) throws IOException, ServletException {
        String username = ((Student) auth.getPrincipal()).getUsername();
        com.example.robin.spring.demo.robins.entities.Student user = userService.FindStudentByUserName(username);

        String role = user.getRole();//"test" ;//authorityService.getUserRole(username_email);


        String token = JWTUtility.buildJWTToken(username, role);
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}
