package com.example.domain.dto.task;

import com.example.domain.enuns.StatusTask;
import jakarta.validation.constraints.NotEmpty;

public class UpdateStatusTaskDto {

    private Long id;

    @NotEmpty(message = "Status can't be blank")
    private StatusTask statusTask;

    public UpdateStatusTaskDto(Long id, StatusTask statusTask) {
        this.id = id;
        this.statusTask = statusTask;
    }

    public UpdateStatusTaskDto() {
    }

    public Long getId() {
        return id;
    }

    public StatusTask getStatusTask() {
        return statusTask;
    }
}
