package com.example.domain.dto.task;

import com.example.domain.enuns.TaskStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class CreateTaskRequestDto {

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;
    private String description;
    private TaskStatus status;
    private Date createdAt;

    public CreateTaskRequestDto() {
    }

    public CreateTaskRequestDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public CreateTaskRequestDto(String title, String description, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
