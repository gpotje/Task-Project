package com.example.domain.entities;

import com.example.domain.enuns.TaskStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Column(name = "created_at")
    private String  createdAt;

    public Task() {}

    public Task(String title, String description, TaskStatus status, String  createdAt ) {
        this.createdAt = createdAt;
        this.status = status;
        this.description = description;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
