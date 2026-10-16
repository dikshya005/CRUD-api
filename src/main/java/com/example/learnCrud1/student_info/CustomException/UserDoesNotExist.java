package com.example.learnCrud1.student_info.CustomException;

public class UserDoesNotExist extends RuntimeException{
    public UserDoesNotExist(String message){
        super(message);
    }
}
