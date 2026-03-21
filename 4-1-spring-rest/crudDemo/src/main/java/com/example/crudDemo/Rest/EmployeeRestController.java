package com.example.crudDemo.Rest;

import com.example.crudDemo.Entity.DAO;
import com.example.crudDemo.Entity.Employees;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private DAO dao;
    public EmployeeRestController(DAO dao){
        this.dao = dao;
    }

    @GetMapping("/employees")
    public List<Employees> finadAll() {
        return dao.readAll();
    }

    private void deletedByID(DAO dao) {
        dao.delete(7);
        System.out.println("Deleted by ID");
    }
    private void findEmployee(DAO dao) {
        Employees emp=dao.read(1);
        System.out.println(emp.getFirstName());
        System.out.println(emp.getLastName());
        System.out.println(emp.getEmail());
    }

    private void createEmployee(DAO dao) {
        Employees emp = new Employees("Santaro","Sama","santarosama@gmail.com");
        dao.add(emp);
    }

    private Employees update(DAO dao){
        dao.update(2,"","Frost","");
        return dao.read(2);
    }
}
