package com.example.robin.spring.demo.robins.services;

import com.example.robin.spring.demo.robins.entities.Student;
import com.example.robin.spring.demo.robins.models.StudentModel;
import com.example.robin.spring.demo.robins.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    private StudentModel studentModel = new StudentModel();

    private Student student = new Student();

    public List<StudentModel> findAllStudents() {

        List<Student> students = studentRepository.findAll();

        List<StudentModel> models = studentModel.studentModelList(students);

        return models;
    }
}
