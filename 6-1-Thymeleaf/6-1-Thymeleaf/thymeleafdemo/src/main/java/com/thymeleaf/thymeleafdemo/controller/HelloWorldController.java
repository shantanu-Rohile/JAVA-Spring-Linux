package com.thymeleaf.thymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-Form";
    }

    @GetMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    @RequestMapping("/processFormVersion2")
    public String processFormVersion2(HttpServletRequest request, Model model){
        String theName=request.getParameter("name");
        theName=theName.toUpperCase();
        String message= "oh! " + theName;
        model.addAttribute("message",message);

        return "helloworld";

    }

    @PostMapping("/processFormVersion3")
    public String processFormVersion3(@RequestParam("name") String theName, Model model){
        theName=theName.toUpperCase();
        String message= "Yo, my boy ! " + theName;
        model.addAttribute("message",message);

        return "helloworld";

    }
}
