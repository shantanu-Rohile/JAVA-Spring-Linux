package com.example.revesion.ENTITY;

import jakarta.persistence.*;
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public int getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "username")
    private String username;

    private enum Role{
        member,
        admin,
        developer
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;
}
