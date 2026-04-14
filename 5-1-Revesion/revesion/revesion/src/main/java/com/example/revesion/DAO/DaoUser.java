package com.example.revesion.DAO;

import com.example.revesion.ENTITY.User;

import java.util.List;

public interface DaoUser {
    String create(User user);
    User findUser(int userid);
    List readUsers();
    String update(int uderid, User user);
    String delete(int id);
}
