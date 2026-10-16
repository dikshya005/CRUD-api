package com.example.learnCrud1.student_info.CustomException;

public class StudentNotSaved extends RuntimeException{
    public StudentNotSaved(String message){
        super(message);

    }
}
