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
    public void add(Employees employees) {
        entityManager.persist(employees);
    }

    @Override
    public Employees read(int id) {
        return entityManager.find(Employees.class,id);
    }

    @Override
    @Transactional
    public Employees update(int id, String firstName, String lastName, String email) {
        Employees emp=entityManager.find(Employees.class,id);
        if(emp!=null && firstName!="" ){
            emp.setFirstName(firstName);
        }else if(lastName!=""){
            emp.setLastName(lastName);
        }else if(email!=""){
            emp.setEmail(email);
        }else{
            System.out.println("No change as you can see below");
        }

        entityManager.merge(emp);
        return emp;

    }

    @Override
    @Transactional
    public void delete(int id) {
        Employees emp=entityManager.find(Employees.class,id);
        entityManager.remove(emp);
    }

    @Override
    public List<Employees> readAll() {
       TypedQuery<Employees> theQuery= entityManager.createQuery("FROM Employees",Employees.class);
       List<Employees> employees=theQuery.getResultList();
        return employees;
    }


}
