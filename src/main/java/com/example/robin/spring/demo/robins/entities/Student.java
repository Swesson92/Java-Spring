package com.example.robin.spring.demo.robins.entities;

import com.example.robin.spring.demo.robins.models.StudentModel;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;


@Entity
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String username;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "topic")
    private String topic;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn
    private Teacher teacher;

    public Student(StudentModel studentModel) {
        this.id = studentModel.getId();
        this.username = studentModel.getUserName();
        this.lastName = studentModel.getLastName();
        this.age = studentModel.getAge();
        this.topic = studentModel.getTopic();
        this.email = studentModel.getEmail();
        this.password = studentModel.getPassword();
        this.role = studentModel.getRole();
    }

    public Student() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
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
