package com.example.learnCrud1.student_info.Controller;

import com.example.learnCrud1.student_info.Service.StudentService;
import com.example.learnCrud1.student_info.dto.StudentRequest;
import com.example.learnCrud1.student_info.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/view_list")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> student = studentService.getStudent();
        return new ResponseEntity<>(student, HttpStatus.OK);

    }

    @PostMapping("/create_student")
    public ResponseEntity<Student> addStudent(@RequestBody StudentRequest request) {
        Student student1 = studentService.addStudent(request);
        return new ResponseEntity<>(student1,HttpStatus.CREATED);

    }
    @PutMapping("/update_student/{id}")
    public ResponseEntity<Void> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
