package com.example.revesion.DAO;

import com.example.revesion.ENTITY.Confession;

import java.util.List;

public interface DaoConfession {
    String create(Confession confession);
    List<Confession> readConfession(int id);
    List<Confession> readConfessions();
    String update();
    String delete();
}
