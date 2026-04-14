package com.example.revesion.REST;


import com.example.revesion.DAO.DaoUser;
import com.example.revesion.ENTITY.User;
import com.example.revesion.SERVICE.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FunRestController {
    private UserService service;
    @Autowired
    public void FunRestController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    public List read() {
        return service.readUsers();
    }

    @PostMapping("/user")
    public String create(@RequestBody User user){
        return service.create(user);
    }

    @GetMapping("user/{userid}")
    public User getUser(@PathVariable int userid){
        return service.findUser(userid);
    }

    @PostMapping("/user/{userid}")
    public String updateUser(@PathVariable int userid, @RequestBody User user){
        service.update(userid,user);
        return "User id : "+userid;
    }

    @DeleteMapping("/user/{userid}")
    public String delete(@PathVariable int userid){
        return service.delete(userid);

    }
    

}
