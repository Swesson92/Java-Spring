package com.example.robin.spring.demo.robins.services;

import com.example.robin.spring.demo.robins.entities.Student;
import com.example.robin.spring.demo.robins.models.StudentModel;
import com.example.robin.spring.demo.robins.repository.StudentRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements StudentServiceInterface, UserDetailsService {


    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    private StudentModel studentModel = new StudentModel();
    private Student student = new Student();

    public List<StudentModel> findAllStudents() {
        List<Student> students = repository.findAll();
        List<StudentModel> models = studentModel.studentModelList(students);
        return models;
    }

    public Student FindStudentByUserName(String username) {
        return repository.findByUsername(username);
    }

    public StudentModel createStudent(StudentModel studentModel) {
        Student student = new Student(studentModel);
        return new StudentModel(repository.save(student));
    }

    public void deleteStudent(@PathVariable Long id){
        repository.deleteById(id);
    }

    private List<StudentModel> convertStudentListToModelList(List<Student> studentList) {
        List<StudentModel> studentModelList = new ArrayList<>();
        for (Student student : studentList) {
            studentModelList.add(new StudentModel(student));
        }
        return studentModelList;

    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Student student = FindStudentByUserName(username);

        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if (student != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(username);
            builder.password(new BCryptPasswordEncoder().encode(student.getPassword()));
            builder.roles(student.getRole());
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }

}