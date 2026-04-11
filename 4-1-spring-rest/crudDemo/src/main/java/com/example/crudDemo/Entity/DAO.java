package com.example.crudDemo.Entity;

import java.util.*;

public interface DAO {
    List<Employees> readAll();


    Employees save(Employees employees);


    Employees findById(int id);


//    Employees update(int id, String firstName, String lastName, String email);


    void deleteById(int id);

}
