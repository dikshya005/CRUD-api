package com.example.learnCrud1.student_info.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class StudentResponseDto {
    private Long id;
    private String name;
    private String address;
    private LocalDateTime createdAt;
   private boolean deleted;

}
