package com.example.robin.spring.demo.robins.models;

import com.example.robin.spring.demo.robins.entities.Student;
import lombok.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class StudentModel implements Serializable {

    private Long id;
    private String username;
    private String lastName;
    private int age;
    private String topic;
    private String email;
    private String password;
    private String role;

    public StudentModel(Student student){
        this.id = student.getId();
        this.username = student.getUsername();
        this.lastName = student.getLastName();
        this.age = student.getAge();
        this.topic = student.getTopic();
        this.email = student.getEmail();
        this.password = student.getPassword();
        this.role = student.getRole();
    }

    public StudentModel() {}


    public List<StudentModel> studentModelList(List<Student> students) {
        List<StudentModel> models = new ArrayList<>();
        students.forEach(student -> {
            StudentModel studentModel = new StudentModel();
            studentModel.id = student.getId();
            studentModel.username = student.getUsername();
            studentModel.lastName = student.getLastName();
            studentModel.age = student.getAge();
            studentModel.topic = student.getTopic();
            studentModel.role = student.getRole();
            studentModel.password = student.getPassword();
            studentModel.email = student.getEmail();
            models.add(studentModel);
        });

        return models;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
