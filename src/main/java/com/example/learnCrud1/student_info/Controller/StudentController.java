package com.example.learnCrud1.student_info.Controller;

import com.example.learnCrud1.student_info.Service.StudentService;
import com.example.learnCrud1.student_info.dto.StudentRequestDto;
import com.example.learnCrud1.student_info.dto.StudentResponseDto;
import com.example.learnCrud1.student_info.model.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:/student/view-list
@RestController
@RequestMapping("/student")
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
    public ResponseEntity<StudentResponseDto> addStudent(@RequestBody StudentRequestDto request) {
        StudentResponseDto student1 = studentService.addStudent(request);
        return new ResponseEntity<>(student1, HttpStatus.CREATED);

    }

    @PutMapping("/update_student/{id}")
    public ResponseEntity<StudentResponseDto> updateStudent(@PathVariable Long id, @RequestBody StudentRequestDto requestDto) {
        StudentResponseDto studentResponseDto = studentService.updateStudent(id, requestDto);
        return new ResponseEntity<>(studentResponseDto,HttpStatus.OK);
    }


    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity<StudentResponseDto> deleteStudent(@PathVariable Long id) {
        StudentResponseDto studentResponseDto=studentService.deleteStudent(id);
        return new ResponseEntity<>(studentResponseDto,HttpStatus.OK);
    }
}

