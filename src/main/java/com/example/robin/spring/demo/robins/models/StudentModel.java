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
    private String name;
    private String lastName;
    private int age;
    private String topic;

    public StudentModel(Student student){
        this.id = student.getId();
        this.name = student.getName();
        this.lastName = student.getLastName();
        this.age = student.getAge();
        this.topic = student.getTopic();
    }

    public StudentModel() {}


    public List<StudentModel> studentModelList(List<Student> students) {

        List<StudentModel> models = new ArrayList<>();

        students.forEach(student -> {
            StudentModel studentModel = new StudentModel();
            studentModel.id = student.getId();
            studentModel.name = student.getName();
            studentModel.lastName = student.getLastName();
            studentModel.age = student.getAge();
            studentModel.topic = student.getTopic();
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
