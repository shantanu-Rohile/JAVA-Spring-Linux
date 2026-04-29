package com.example.revesion.DAO;

import jakarta.persistence.EntityManager;

public class DaoAuthoritiesImpl implements DaoAuthorities {

    private EntityManager em;

    public DaoAuthoritiesImpl(EntityManager em){
        this.em=em;
    }
    @Override
    public String assign(String role, String username) {
        em.persist();
        return "";
    }

    @Override
    public String delete() {
        return "";
    }
}
