package com.example.revesion.REST;

import com.example.revesion.DAO.DaoReport;
import com.example.revesion.ENTITY.Report;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;
import java.util.Objects;


@RestController
public class ReportController {

    private DaoReport dao;

    @Autowired
    public ReportController(DaoReport dao, JsonMapper jsonMapper){
        this.dao=dao;
    }

    @GetMapping("/reports")
    public List<Report> allReports(){
        return dao.readAllReport();
    }

    @PostMapping("/reports")
    public String create(@RequestBody Report report){
        return dao.create(report);
    }

    @GetMapping("/reports/{id}")
    public Report report(@PathVariable int id){
        return dao.readReports(id);
    }

    @PatchMapping("/reports/{id}")
    public Report update(@PathVariable int id, @RequestBody Map<String, Objects> patchBody){
        return dao.update(id,patchBody);
    }

    @DeleteMapping("/reports/{id}")
    public String delete(@PathVariable int id){
        return dao.delete(id);
    }

}
