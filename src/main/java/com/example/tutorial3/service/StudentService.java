package com.example.tutorial3.service;

import com.example.tutorial3.model.StudentModel;

import java.util.List;

public interface StudentService {
    StudentModel selectStudent(String npm);

    List<StudentModel> selectAllStudent();

    void addStudent(StudentModel student);
}
