package com.example.domain.dto.task;

import com.example.domain.enuns.StatusTask;

import java.util.Date;

public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private StatusTask status;
    private String createdAt;

    public TaskDto(Long id, String title, String description, StatusTask status, String createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
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

    public StatusTask getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
