package com.example.learnCrud1.student_info.CustomException;

public class StudentDoesNotExistException extends RuntimeException{
    public StudentDoesNotExistException(String message){
        super(message);
    }
}
