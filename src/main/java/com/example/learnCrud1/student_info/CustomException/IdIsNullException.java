package com.example.learnCrud1.student_info.CustomException;

public class IdIsNullException extends RuntimeException{
    public IdIsNullException(String message){
        super(message);
    }
}
