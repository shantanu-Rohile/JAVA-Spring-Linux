package com.example.revesion.ENTITY;

import jakarta.persistence.*;

@Entity
@Table(name = "reaction")
public class Reaction {

    @Id
    @Column(name="id")
    private int id;

    public enum React{
        LIKE,
        DISLIKE
    };

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private React type;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
