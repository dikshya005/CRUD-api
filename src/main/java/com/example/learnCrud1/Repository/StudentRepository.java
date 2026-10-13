package com.example.learnCrud1.Repository;

import com.example.learnCrud1.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
