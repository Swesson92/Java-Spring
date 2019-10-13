package com.example.robin.spring.demo.robins.models;

import com.example.robin.spring.demo.robins.entities.Student;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentModel {

    private Long id;
    private String name;
    private String lastName;
    private int age;


    public List<StudentModel> studentModelList(List<Student> students) {

        List<StudentModel> models = new ArrayList<>();

        students.forEach(student -> {
            StudentModel studentModel = new StudentModel();
            studentModel.id = student.getId();
            studentModel.name = student.getName();
            studentModel.lastName = student.getLastName();
            studentModel.age = student.getAge();
            models.add(studentModel);
        });

        return models;
    }
}
