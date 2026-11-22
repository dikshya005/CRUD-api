package com.example.learnCrud1.student_info.CustomException;

public class UserDoesNotExistException extends RuntimeException{
    public UserDoesNotExistException(String message){
        super(message);
    }
}
