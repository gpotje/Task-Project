package com.example.domain.dto.task;

import com.example.domain.enuns.StatusTask;

import java.util.Date;

public class ListAllTaskDto {
    private Long id;
    private String title;
    private String description;
    private StatusTask status;
    private Date createdAt;

    public ListAllTaskDto(Long id, String title, String description, StatusTask status, Date createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }
}
