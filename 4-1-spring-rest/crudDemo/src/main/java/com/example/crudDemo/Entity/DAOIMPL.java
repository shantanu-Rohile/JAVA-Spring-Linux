package com.example.crudDemo.Entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class DAOIMPL implements DAO {

    private EntityManager entityManager;
    @Autowired
    public DAOIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public List<Employees> readAll() {
       TypedQuery<Employees> theQuery= entityManager.createQuery("FROM Employees",Employees.class);
       List<Employees> employees=theQuery.getResultList();
        return employees;
    }

    @Override
    @Transactional
    public Employees save(Employees employees) {
        Employees emp=entityManager.merge(employees);
        return emp;
    }

    @Override
    public Employees findById(int id) {
        Employees emp=entityManager.find(Employees.class,id);
        return emp;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Employees emp= findById(id);
        entityManager.remove(emp);
    }


}
