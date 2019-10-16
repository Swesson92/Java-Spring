package com.example.robin.spring.demo.robins.config;

import com.example.robin.spring.demo.robins.jwt.JWTAuthenticationFilter;
import com.example.robin.spring.demo.robins.jwt.JWTAuthorizationFilter;
import com.example.robin.spring.demo.robins.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {



        private final BCryptPasswordEncoder bCryptPasswordEncoder;
        private final UserDetailsService userDetailsService;


    @Autowired
        public SecurityConfig(BCryptPasswordEncoder bCryptPasswordEncoder, StudentService studentService) {
            this.bCryptPasswordEncoder = bCryptPasswordEncoder;
            this.userDetailsService = studentService;
        }


  /*  @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/public").permitAll()
                .anyRequest().authenticated()
                .and()
             //   .addFilter(new JWTAuthenticationFilter(authenticationManager()))
             //   .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
*/
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);

        }
}
