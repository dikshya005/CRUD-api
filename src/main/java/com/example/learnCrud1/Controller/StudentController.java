package com.example.learnCrud1.Controller;

import com.example.learnCrud1.Service.StudentService;
import com.example.learnCrud1.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/view_list")
    public List<Student> GetAllStudent() {

        List<Student>  student = studentService.getStudent();
        return student;

    }

    @PostMapping("/create_student")
    public Student addStudent( @RequestBody Student student){
        return studentService.addStudent(student);

    }

    @PutMapping("/update_student/{id}")
    public void updateStudent(@PathVariable Long id, @RequestBody Student student){

         studentService.updateStudent(id, student);
    }


    @DeleteMapping("/delete_student/{id}")
    public  void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);

    }
}
