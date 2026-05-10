package com.luv2code.springboot.thymeleafdemo.Controller;


import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String list(Model theModel) {
        List<Employee> theEmployees = employeeService.findAll();
        theModel.addAttribute("employees",theEmployees);
        return "list-employees";
    }

    @GetMapping("/add")
    public String add(Model theModel){
        Employee theEmployee = new Employee();
        theModel.addAttribute("employees",theEmployee);
        return "add-employee";
    }

    @GetMapping("/showUpdateForm")
    public String showUpdateForm(@RequestParam ("employeeId") int empId, Model theModel){
        Employee theEmployee= employeeService.findById(empId);
        theModel.addAttribute("employees",theEmployee);

        return "employee-form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute ("employee") Employee theEmployee){
            employeeService.save(theEmployee);
            return "redirect:/employee/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam ("employeeId") int empId){
        employeeService.deleteById(empId);
        return "redirect:/employee/list";
    }

}
