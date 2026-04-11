package com.example.crudDemo.Rest;

import com.example.crudDemo.Entity.Employees;
import com.example.crudDemo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/")
public class REST {

    private EmployeeService employeeService;

    private JsonMapper jsonMapper=new JsonMapper();


    @Autowired
    public REST(EmployeeService theEmployeeService, JsonMapper jsonMapper) {
        employeeService=theEmployeeService;
        jsonMapper=jsonMapper;
    }

    @GetMapping("/allEmployee")
    public List<Employees> findAll() {
        return employeeService.findAll();
    }


    @GetMapping("/allEmployee/{empid}")
    public Employees findByid(@PathVariable int empid){
        return employeeService.findById(empid);
    }


    @PostMapping("/allEmployee")
    public Employees save(@RequestBody Employees emp){
        emp.setId(0);
        Employees newEmp=employeeService.save(emp);
        return newEmp;
    }


    @PutMapping("allEmployee")
    public  Employees updateEmployee(@RequestBody  Employees theEmployee){
        Employees emp = employeeService.save(theEmployee);
        return emp;
    }


    @PatchMapping("allEmployee/{employeeId}")
    public Employees patchEmployees (@PathVariable int employeeId, @RequestBody Map<String,Object> patchBody){

        Employees emp=employeeService.findById(employeeId);
        if(emp==null){
            throw new RuntimeException("Employee with employee id '"+employeeId+"' not found");
        }
        if(patchBody.containsKey("id")){
            throw new RuntimeException("The Employee id is immutable");
        }

        Employees PatchedEmployee=jsonMapper.updateValue(emp,patchBody);

        Employees dbEmployee=employeeService.save(PatchedEmployee);

        return dbEmployee;

    }

    @DeleteMapping("/allEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employees emp=employeeService.findById(employeeId);
        if(emp==null){
            throw new RuntimeException("Employee with employee id '"+employeeId+"' is not available");
        }
        employeeService.detelteById(employeeId);

        return "Employee with employee id '"+employeeId+"' is successfully deleted";

    }
}
