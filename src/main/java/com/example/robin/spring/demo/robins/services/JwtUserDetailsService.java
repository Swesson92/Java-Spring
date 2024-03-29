package com.example.robin.spring.demo.robins.services;

import com.example.robin.spring.demo.robins.entities.Student;
import com.example.robin.spring.demo.robins.models.StudentModel;
import com.example.robin.spring.demo.robins.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("javainuse".equals(username)) {
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }

    public Student save(StudentModel user) {
        Student newUser = new Student();
        newUser.setUsername(user.getUserName());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return studentRepository.save(newUser);
    }


}
