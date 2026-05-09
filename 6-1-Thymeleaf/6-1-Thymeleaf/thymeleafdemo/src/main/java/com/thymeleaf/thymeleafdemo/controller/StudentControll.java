package com.thymeleaf.thymeleafdemo.controller;

import com.thymeleaf.thymeleafdemo.Model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentControll {

    @Value("${countries}")
    List<String> countries;

    @Value("${languages}")
    List<String> languages;

    @GetMapping("/showStudentForm")
    public String showStudentForm(Model model){
        Student theStudent=new Student();
        model.addAttribute("Student",theStudent);
        model.addAttribute("countries",countries);
        model.addAttribute("languages",languages);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("Student") Student theStudent){
        System.out.println("theStudent:"+theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";
    }
}
