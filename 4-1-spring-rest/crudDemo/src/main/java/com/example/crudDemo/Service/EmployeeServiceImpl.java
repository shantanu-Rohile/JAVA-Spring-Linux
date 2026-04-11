package com.example.crudDemo.Service;

import com.example.crudDemo.Entity.DAO;
import com.example.crudDemo.Entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService  {

    private DAO dao;

    @Autowired
    public EmployeeServiceImpl(DAO theDAO){
        dao=theDAO;
    }

    @Override
    public List<Employees> findAll(){
        return dao.readAll();
    }

    @Override
    public Employees save(Employees emp) {
        return dao.save(emp);
    }

    @Override
    public void detelteById(int id) {
        dao.deleteById(id);
        System.out.print("The Employee with id "+id+" is deleted");
    }

    @Override
    public Employees findById(int id) {
        return dao.findById(id);
    }
}
