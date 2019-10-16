package com.example.robin.spring.demo.robins.entities;

import lombok.*;
import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Teacher {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Student> students;

}
