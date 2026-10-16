package com.example.learnCrud1.student_info.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentRequest {
    private String name;
    private String address;
    private String password;
}
