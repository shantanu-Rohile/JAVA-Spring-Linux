package com.example.crudDemo.Service;

import com.example.crudDemo.Entity.Employees;
import com.example.crudDemo.dao.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService  {


    @Autowired
    private EmployeeRepository employeeRepository;
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository=theEmployeeRepository;
    }

    @Override
    public List<Employees> findAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employees save(Employees emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public void detelteById(int id) {
        employeeRepository.deleteById(id);
        System.out.print("The Employee with id "+id+" is deleted");
    }

    @Override
    public Employees findById(int id) {
        Optional<Employees> result = employeeRepository.findById(id);
        Employees theEmployee=null;
        if(result.isPresent()){
           theEmployee=result.get();
        }else{
            throw new RuntimeException("Did not find the employee : " + id);
        }
        return theEmployee;
    }
}
