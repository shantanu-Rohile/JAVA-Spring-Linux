package com.example.demo.rest;

import com.example.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;

import java.util.*;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students=new ArrayList<>();

    @PostConstruct
    public void loadData(){
        students.add(new Student("Shantanu","Rohile"));
        students.add(new Student("Gwen","learn2cloud"));
        students.add(new Student("Adrea","learn2cloud"));
        students.add(new Student("Aryan","Lokhande"));
        students.add(new Student("Sandesh","Pasalkar"));
    }

    @GetMapping("/names")
    public List getNames(){
        return students;
    }

    //Defin the url for only one student

    @GetMapping("/names/{student_id}")
    public Student getName(@PathVariable int student_id){
        if(students.size()<=student_id || student_id<0){
            throw new StudentNotFound("Student Not Found"+student_id);
        }

        return students.get(    student_id);
    }


}
