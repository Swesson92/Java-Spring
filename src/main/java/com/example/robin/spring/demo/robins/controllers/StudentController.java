package com.example.robin.spring.demo.robins.controllers;

import com.example.robin.spring.demo.robins.entities.Student;
import com.example.robin.spring.demo.robins.models.StudentModel;
import com.example.robin.spring.demo.robins.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/students")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<StudentModel>>getAllStudents() {

        List<StudentModel> students = studentService.findAllStudents();

        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<StudentModel> createStudent(@RequestBody StudentModel studentModel){
        StudentModel student = studentService.createStudent(studentModel);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }


}
