package com.example.domain.dto.task;

import com.example.domain.enuns.TaskStatus;

public class UpdateStatusRequestDto {

    private TaskStatus status;

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }



}
