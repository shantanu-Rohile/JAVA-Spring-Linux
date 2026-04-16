package com.example.revesion.REST;

import com.example.revesion.DAO.DaoConfession;
import com.example.revesion.ENTITY.Confession;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConfessionController {
    private DaoConfession dao;
    public ConfessionController( DaoConfession dao) {
       this.dao=dao;
    }

    @GetMapping("/confession/{id}")
    public List<Confession> readConfession(@PathVariable int id){
        return dao.readConfession(id);
    }

    @GetMapping("/confession")
    public List<Confession> readConfession(){
        return dao.readConfessions();
    }

    @PostMapping("/confession")
    public String createConfession(@RequestBody Confession confession){
        return dao.create(confession);
    }
}
