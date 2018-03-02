package com.example.tutorial3.service;

import com.example.tutorial3.model.StudentModel;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentService implements StudentService{
    public static List<StudentModel> studentList = new ArrayList<StudentModel>();

    @Override
    public StudentModel selectStudent(String npm){
        //implement
        for (StudentModel i : studentList){
            if(i.getNpm().equals(npm)){
                return i;
            }
        }
        return null;
    }

    @Override
    public List<StudentModel> selectAllStudent() {
        return studentList;
    }

    @Override
    public void addStudent(StudentModel student) {
        studentList.add(student);
    }

    @Override
    public void deleteStudent(StudentModel student){
        studentList.remove(student);
    }


}
