package com.example.learnCrud1.student_info.CustomException;

public class StudentNotSavedException extends RuntimeException{
    public StudentNotSavedException(String message){
        super(message);

    }
}
