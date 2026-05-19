package com.example.domain.dto.task;

import com.example.domain.enuns.StatusTask;
import jakarta.validation.constraints.NotEmpty;

public class UpdateStatusRequestDto {

    private StatusTask status;

    public StatusTask getStatus() {
        return status;
    }

    public void setStatus(StatusTask status) {
        this.status = status;
    }



}
