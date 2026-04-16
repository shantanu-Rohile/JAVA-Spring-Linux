package com.example.revesion.ENTITY;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="confession")
public class Confession {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "confession_id")
    private int id;

    @Column(name="content")
    private String content;

    @Column(name="created_at",updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    private enum Status{
        ACTIVE,
        REMOVED
    }

    @Enumerated(EnumType.STRING)
    @Column(name="is_active")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
