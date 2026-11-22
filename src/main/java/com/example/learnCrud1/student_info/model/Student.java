package com.example.learnCrud1.student_info.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String address;
    @Column
    private String password;
    @Column(nullable = false)
    private boolean deleted = false;
    @Column
    private LocalDateTime createdAt;

}
