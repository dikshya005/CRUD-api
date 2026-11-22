package com.example.learnCrud1.student_info.Service;

import com.example.learnCrud1.student_info.CustomException.StudentDoesNotExistException;
import com.example.learnCrud1.student_info.CustomException.StudentNotSavedException;
import com.example.learnCrud1.student_info.CustomException.UserDoesNotExistException;
import com.example.learnCrud1.student_info.Repository.StudentRepository;
import com.example.learnCrud1.student_info.dto.StudentRequestDto;
import com.example.learnCrud1.student_info.dto.StudentResponseDto;
import com.example.learnCrud1.student_info.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class StudentService {


    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }


    public StudentResponseDto addStudent(StudentRequestDto studentRequestDto) {
        StudentResponseDto responseDto = new StudentResponseDto();
        Student save = new Student();
        save.setName(studentRequestDto.getName());
        save.setAddress(studentRequestDto.getAddress());
        save.setPassword(studentRequestDto.getPassword());
        save.setCreatedAt(LocalDateTime.now());
        try {
            Student save1 = studentRepository.save(save);
            responseDto.setName(save1.getName());
            responseDto.setAddress(save1.getAddress());
            responseDto.setCreatedAt(save1.getCreatedAt());
            responseDto.setId(save1.getId());
            responseDto.setDeleted(save1.isDeleted());


        } catch (Exception e) {
            throw new StudentNotSavedException("student doesn't exist");
        }
        return responseDto;

    }

    //    public void updateStudent(Long id, Student student) {
    public StudentResponseDto updateStudent(Long id, StudentRequestDto studentRequestDto) {
//        Student saved = studentRepository.findById(id).get();
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        Optional<Student> saved = studentRepository.findById(id);
        if (saved.isPresent()) {
            Student student1 = saved.get();


            if (studentRequestDto.getName() != null && !studentRequestDto.getName().isEmpty()) {
                student1.setName(studentRequestDto.getName());

            }
            if (studentRequestDto.getAddress() != null && !studentRequestDto.getAddress().isEmpty()) {
                student1.setAddress(studentRequestDto.getAddress());

            }
            studentRepository.save(student1);

            studentResponseDto.setName(student1.getName());
            studentResponseDto.setAddress(student1.getAddress());
            studentResponseDto.setCreatedAt(LocalDateTime.now());
            studentResponseDto.setId(student1.getId());
        } else {
            throw new StudentDoesNotExistException("Student doesn't exist");
        }

        return studentResponseDto;

    }

    public StudentResponseDto deleteStudent(Long id) {


        if (!studentRepository.existsById(id)) {
            throw new UserDoesNotExistException("Id does not exist in db " + id);
        }

        studentRepository.deleteById(id);
        StudentResponseDto studentResponseDto = new StudentResponseDto();

        studentResponseDto.setId(id);
        studentResponseDto.setDeleted(true);


        return studentResponseDto;
    }


}
