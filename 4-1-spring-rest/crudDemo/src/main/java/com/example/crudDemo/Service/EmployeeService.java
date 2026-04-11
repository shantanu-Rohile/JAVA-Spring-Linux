package com.example.crudDemo.Service;

import com.example.crudDemo.Entity.Employees;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {
    List<Employees> findAll();
    Employees save(Employees emp);
    void detelteById(int id);
    Employees findById(int id);
}
