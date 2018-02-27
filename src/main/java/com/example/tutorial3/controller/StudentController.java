package com.example.tutorial3.controller;

import com.example.tutorial3.model.StudentModel;
import com.example.tutorial3.service.InMemoryStudentService;
import com.example.tutorial3.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController() {
        this.studentService = new InMemoryStudentService();
    }

    @RequestMapping("/student/add")
    public String add(@RequestParam(value = "npm", required = true) String npm, @RequestParam(value = "name", required = true) String name, @RequestParam(value = "gpa", required = true) Double gpa) {
        StudentModel student = new StudentModel(npm, name, gpa);
        studentService.addStudent(student);
        return "add";
    }

    @RequestMapping("/student/view")
    public String view(Model model, @RequestParam(value = "npm", required = true) String npm){
        StudentModel student = studentService.selectStudent(npm);
        model.addAttribute("student", student);
        return "view";
    }

//    @RequestMapping("/student/view/{npm}")
//    public String view(@PathVariable Optional<String> npm, Model model){
//        if (npm.isPresent()){
//            StudentModel student = studentService.selectStudent(npm);
//            model.addAttribute("student", student);
//            return "view";
//        }else{
//            return "error";
//        }
//    }

    @RequestMapping("/student/viewall")
    public String viewall(Model model){
        List<StudentModel> students = studentService.selectAllStudent();
        model.addAttribute("students",students);
        return "viewall";
    }
}
