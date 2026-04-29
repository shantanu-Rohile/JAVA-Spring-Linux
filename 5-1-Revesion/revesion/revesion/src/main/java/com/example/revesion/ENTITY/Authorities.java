package com.example.revesion.ENTITY;


import jakarta.persistence.*;

@Entity
@Table(name="Authorities")
public class Authorities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private enum Role {
        ROLE_user,
        ROLE_manager,
        ROLE_developer
    }

    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private Role role;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;
}
