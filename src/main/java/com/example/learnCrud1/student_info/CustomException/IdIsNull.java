package com.example.learnCrud1.student_info.CustomException;

public class IdIsNull extends RuntimeException{
    public IdIsNull(String message){
        super(message);
    }
}
