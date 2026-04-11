package com.example.crudDemo.dao;

import com.example.crudDemo.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members  ")
public interface EmployeeRepository extends JpaRepository<Employees,Integer> {

}
