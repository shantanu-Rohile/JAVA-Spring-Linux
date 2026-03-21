package com.example.JPA.Task;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DAOIMPL implements DAO {

    private final EntityManager entityManager;
    @Autowired
    public DAOIMPL(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(com.example.JPA.Task.Task task) {
        entityManager.persist(task);
    }

    @Override
    public Task findById(Integer id) {
        Task t1=entityManager.find(Task.class, id);
        return t1;
    }

    @Override
    @Transactional
    public void deletedById(Integer id) {
        Task t2=findById(id);
        System.out.println("Task to be deleted : "+t2);
        entityManager.remove(t2);
        System.out.println(t2 + "has been deleted");
    }

    @Override
    @Transactional
    public void patchDeleted(int[] arr) {
        for(int i=0;i<arr.length;i++){
            deletedById(arr[i]);
        }
        System.out.println("All tasks are deleted");
    }


    @Override
    @Transactional
    public Task updateById(Integer id, String task) {
        Task t=findById(id);
        t.setTask(task);
        entityManager.merge(t);
        return t;
    }


}
