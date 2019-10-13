package com.example.robin.spring.demo.robins.repository;

import com.example.robin.spring.demo.robins.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
