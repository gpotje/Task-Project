package com.example.domain.dto;

import com.example.domain.enuns.StatusTask;
import jakarta.validation.constraints.NotBlank;

import java.util.Date;

public class CreateTaskRequestDto {

    @NotBlank(message = "Title can't be blank")
    private String title;
    private String description;
    private StatusTask status;
    private Date createdAt;

    public String getTitle() {
        return title;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public StatusTask getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
