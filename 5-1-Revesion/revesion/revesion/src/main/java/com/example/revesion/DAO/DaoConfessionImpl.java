package com.example.revesion.DAO;

import com.example.revesion.ENTITY.Confession;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DaoConfessionImpl implements DaoConfession {

    private EntityManager em;
    public DaoConfessionImpl(EntityManager em) {
        this.em=em;
    }

    @Transactional
    @Override
    public String create(Confession confession) {
        em.persist(confession);
        return "New Confession has been added";
    }

    @Override
    public List<Confession> readConfession(int userId) {
        return em.createNativeQuery(
                        "SELECT * FROM confession WHERE user_id = ?",
                        Confession.class)
                .setParameter(1, userId)
                .getResultList();
    }

    @Override
    public List<Confession> readConfessions() {
        List<Confession> confessions= em.createNativeQuery("SELECT * FROM confession").getResultList();
        return confessions;
    }

    @Override
    public String update() {
        return "";
    }

    @Override
    public String delete() {
        return "";
    }
}
