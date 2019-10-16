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
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "topic")
    private String topic;

    @ManyToOne
    @JoinColumn
    private Teacher teacher;

    public Student(StudentModel studentModel) {
        this.id = studentModel.getId();
        this.name = studentModel.getName();
        this.lastName = studentModel.getLastName();
        this.age = studentModel.getAge();
        this.topic = studentModel.getTopic();
    }

    public Student() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
