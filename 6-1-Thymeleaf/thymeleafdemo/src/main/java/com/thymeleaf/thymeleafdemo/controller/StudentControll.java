package com.thymeleaf.thymeleafdemo.controller;

import com.thymeleaf.thymeleafdemo.Model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentControll {
    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model){
        Student theStudent=new Student();
        model.addAttribute("Student",theStudent);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("Student") Student theStudent){
        System.out.println("theStudent:"+theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";
    }
}
