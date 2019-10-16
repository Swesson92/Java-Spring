package com.example.robin.spring.demo.robins.repository;

import com.example.robin.spring.demo.robins.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
