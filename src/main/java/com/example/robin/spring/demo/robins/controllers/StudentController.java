package com.example.robin.spring.demo.robins.controllers;

import com.example.robin.spring.demo.robins.models.StudentModel;
import com.example.robin.spring.demo.robins.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentModel>>getAllStudents() {

        List<StudentModel> students = studentService.findAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
