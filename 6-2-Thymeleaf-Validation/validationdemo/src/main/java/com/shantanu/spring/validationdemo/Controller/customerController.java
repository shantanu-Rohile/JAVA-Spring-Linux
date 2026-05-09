package com.shantanu.spring.validationdemo.Controller;


import com.shantanu.spring.validationdemo.Model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class customerController {

    @InitBinder
    public void initBinder(WebDataBinder binder){
        StringTrimmerEditor stringTrimmerEditor =new StringTrimmerEditor(true);

        binder.registerCustomEditor(String.class,stringTrimmerEditor);
    }


    @GetMapping("/")
    public String showFOrm(Model theModel){
        theModel.addAttribute("customer",new Customer());
        return "customer-form";
    }
    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer theCustomer, BindingResult theBindingResult){
        if(theBindingResult.hasErrors()){
            return "customer-form";
        }else{
            return "confirmation-form";
        }
    }


}
