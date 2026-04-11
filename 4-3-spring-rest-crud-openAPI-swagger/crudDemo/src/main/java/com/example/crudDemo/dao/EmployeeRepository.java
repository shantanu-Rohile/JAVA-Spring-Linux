package com.example.crudDemo.dao;

import com.example.crudDemo.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employees,Integer> {

}
