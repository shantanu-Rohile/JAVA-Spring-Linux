package com.example.JPA.Task;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="daily_task")
public class Task {
    public Task(){

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="date")
    private LocalDate date;

    @Column(name="task")
    private String task;

    @Column(name="start_time")
    private LocalTime startTime;

    @Column(name="end_time")
    private LocalTime endTime;


    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Task(LocalDate date, String task, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.task = task;
        this.startTime = startTime;
        this.endTime = endTime;
    }


}
