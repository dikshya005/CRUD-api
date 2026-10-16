package com.example.learnCrud1.student_info.CustomException;

public class StudentDoesNotExist extends RuntimeException{
    public StudentDoesNotExist(String message){
        super(message);
    }
}
