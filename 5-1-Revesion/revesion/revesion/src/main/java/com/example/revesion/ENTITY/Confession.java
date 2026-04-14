package com.example.revesion.ENTITY;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="confession")
public class Confession {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="content")
    private String content;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    private enum Status{
        ACTIVE,
        REMOVED
    }

    @Enumerated(EnumType.STRING)
    @Column(name="is_active")
    private Status status;

    @ManyToOne
    private User UserId;

}
