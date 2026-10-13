package com.example.learnCrud1.Service;


import com.example.learnCrud1.Repository.StudentRepository;
import com.example.learnCrud1.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {


    private StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent(){
        return studentRepository.findAll();
    }


    public Student addStudent(Student student){
        Student save=studentRepository.save(student);
        return save;

    }

    public void updateStudent(Long id, Student student){
        Optional<Student> byId =studentRepository.findById(id);

        if(byId!=null){
            Student saved= byId.get();
            if (student.getName()!=null && !student.getName().isEmpty()){
                saved.setName(student.getName());

                if(student.getAddress()!=null && !student.getAddress().isEmpty()){
                    saved.setAddress(student.getAddress());

                }

            }


        }
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);

    }




}
