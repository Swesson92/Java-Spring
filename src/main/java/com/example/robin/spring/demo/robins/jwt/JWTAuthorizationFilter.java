package com.example.robin.spring.demo.robins.jwt;

import com.example.robin.spring.demo.robins.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public static final String TOKEN_PREFIX     = "Bearer ";
    public static final String HEADER_STRING    = "Authorization";
    private StudentService userService;


    @Autowired
    public JWTAuthorizationFilter(AuthenticationManager authManager, ApplicationContext ctx) {
        super(authManager);
        this.userService = ctx.getBean(StudentService.class);
    }

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(null, null);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);

        if (header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        if (authentication == null) {
            res.setStatus(401); // UNAUTHORIZED
            res.setHeader("Error", "unauthorized");
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }



    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        if (token != null) {
            String user = JWTUtility.parseUsername(token);
            if (user != null) {
                String userRoleAuth = userService.FindStudentByUserName(user).getRole();//"test"; //authorityService.getUserRole(user);
                List<GrantedAuthority> grantedAuths = getGrantedAuthList(userRoleAuth);
                return new UsernamePasswordAuthenticationToken(user, null, grantedAuths);
            }
        }
        return null;
    }

    private List<GrantedAuthority> getGrantedAuthList(String userRoleAuth) {
        if (userRoleAuth == null) return new ArrayList<>();
        return AuthorityUtils.commaSeparatedStringToAuthorityList(userRoleAuth);
    }

}
