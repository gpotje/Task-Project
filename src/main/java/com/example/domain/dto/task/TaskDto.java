package com.example.domain.dto.task;

import com.example.domain.enuns.TaskStatus;

public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private String createdAt;

    public TaskDto(Long id, String title, String description, TaskStatus status, String createdAt) {
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

    public TaskStatus getStatus() {
        return status;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
