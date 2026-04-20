package com.example.revesion.ENTITY;


import jakarta.persistence.*;

@Entity
@Table(name="report")
public class Report {
    @Id
    @Column(name="id")
    private int id;

    public enum Reports{
        OFFENSIVE,
        ABUSIVE,
        MODERATE,
        NONE,
    }

    @Enumerated(EnumType.STRING)
    @Column(name="report")
    private Reports report;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Reports getReport() {
        return report;
    }

    public void setReport(Reports report) {
        this.report = report;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
