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
public class studentModel {

    private Long id;
    private String name;
    private String lastName;
    private int age;


    public List<studentModel> studentModelList(List<Student> students) {

        List<studentModel> models = new ArrayList<>();

        students.forEach(student -> {
            studentModel studentModel = new studentModel();
            studentModel.id = student.getId();
            studentModel.name = student.getName();
            studentModel.lastName = student.getLastName();
            studentModel.age = student.getAge();
            models.add(studentModel);
        });

        return models;
    }
}
