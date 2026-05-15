package com.example.domain.entities;

import com.example.domain.enuns.StatusTask;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tb_task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private StatusTask status;

    @Column(name = "created_at")
    private String  createdAt;

    public Task() {}

    public Task( String title, String description,StatusTask status, String  createdAt ) {
        this.createdAt = createdAt;
        this.status = status;
        this.description = description;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createdAt=" + createdAt +
                '}';
    }
}
