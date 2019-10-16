package com.example.robin.spring.demo.robins.repository;

import com.example.robin.spring.demo.robins.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByUsername(String username);
}
