package com.example.crudDemo.Entity;

import java.util.*;

public interface DAO {
    void add(Employees employees);
    Employees read(int id);
    Employees update(int id, String firstName, String lastName, String email);
    void delete(int id);
    List<Employees> readAll();
}
