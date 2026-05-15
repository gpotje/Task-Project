package com.example.service;

import com.example.domain.dto.task.CreateTaskRequestDto;
import com.example.domain.dto.CreateResponseDto;
import com.example.domain.entities.Task;
import com.example.domain.enuns.StatusTask;
import com.example.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class TaskService {

    private TaskRepository repository;

    public TaskService(TaskRepository repository){
        this.repository = repository;
    }

    public CreateResponseDto createTask(CreateTaskRequestDto dto){
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");

        String dataFormatada = LocalDateTime.now().format(formatter);

        Task taskResponse  = repository.save(new Task(
                dto.getTitle(),
                dto.getDescription(),
                dto.getStatus() == null ? StatusTask.IN_PROGRESS : dto.getStatus(),
                dataFormatada));

        return new CreateResponseDto(taskResponse.getId());
    }


}
