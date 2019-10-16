package com.example.robin.spring.demo.robins.entities;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Teacher {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "teacher")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "age")
    private int age;
    @Column(name = "subject")
    private String subject;

    @JoinColumn(name = "student", referencedColumnName = "id")
    private Student student;



}
