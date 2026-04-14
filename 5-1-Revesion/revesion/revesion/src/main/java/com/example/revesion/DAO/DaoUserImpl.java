package com.example.revesion.DAO;

import com.example.revesion.ENTITY.User;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoUserImpl implements DaoUser {

    private EntityManager entityManager;

    public DaoUserImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public String create(User user) {
        if(user == null){
            return "Please Add valid user";
        }else{
            entityManager.merge(user);
        }

        return"User is Created";
    }

    @Override
    public List readUsers() {
        List<User> lst=entityManager.createNativeQuery("SELECT * FROM user", User.class).getResultList();
        return lst;
    }

    @Override
    public User findUser(int userid){
        return entityManager.find(User.class, userid);
    }

    @Override
    public String update(int userid, User user) {
        User u =entityManager.find(User.class, userid);
        u.setUsername(user.getUsername());
        u.setRole(user.getRole());
        User u1=entityManager.merge(u);
        return "User updated successfully";
    }

    @Transactional
    @Override
    public String delete(int id) {
        entityManager.remove(entityManager.find(User.class, id));
        return "User id : "+id+" has been deleted";
    }
}
