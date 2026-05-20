package com.example.domain.dto.task;

import com.example.domain.enuns.TaskStatus;
import jakarta.validation.constraints.NotEmpty;

public class UpdateStatusTaskDto {

    private Long id;

    @NotEmpty(message = "Status can't be blank")
    private TaskStatus statusTask;

    public UpdateStatusTaskDto(Long id, TaskStatus statusTask) {
        this.id = id;
        this.statusTask = statusTask;
    }

    public UpdateStatusTaskDto() {
    }

    public Long getId() {
        return id;
    }

    public TaskStatus getStatusTask() {
        return statusTask;
    }
}
