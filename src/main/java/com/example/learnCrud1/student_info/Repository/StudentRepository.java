package com.example.learnCrud1.student_info.Repository;

import com.example.learnCrud1.student_info.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
