package com.example.revesion.SERVICE;

import com.example.revesion.DAO.DaoUser;
import com.example.revesion.ENTITY.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    private DaoUser dao;

    @Autowired
    public UserServiceImpl(DaoUser dao){
        this.dao=dao;
    }

    @Transactional
    @Override
    public String create(User user) {
        return dao.create(user);
    }

    @Override
    public User findUser(int userid) {
        return dao.findUser(userid);
    }

    @Override
    public List readUsers() {
        return dao.readUsers();
    }

    @Override
    public String update(int uderid, User user) {
        return dao.update(uderid, user);
    }

    @Transactional
    @Override
    public String delete(int id) {
        return dao.delete(id);
    }
}
