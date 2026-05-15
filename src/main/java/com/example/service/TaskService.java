package com.example.service;

import com.example.domain.dto.CreateTaskRequestDto;
import com.example.domain.dto.CreateTaskResponseDto;
import com.example.domain.entities.Task;
import com.example.domain.enuns.StatusTask;
import com.example.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskService {

    private TaskRepository repository;

    public TaskService(TaskRepository repository){
        this.repository = repository;
    }

    public CreateTaskResponseDto createTask(CreateTaskRequestDto dto){


        Task task = new Task(
                dto.getTitle(),
                dto.getDescription(),
                dto.getStatus() == null ? StatusTask.IN_PROGRESS : dto.getStatus(),
                new Date());

        System.out.println("=================================");
        task.toString();
        Task taskResponse  = repository.save(task);

        return  new CreateTaskResponseDto(taskResponse.getId());
    }


}
