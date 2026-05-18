package com.example.service;

import com.example.domain.dto.task.CreateTaskRequestDto;
import com.example.domain.dto.CreateResponseDto;
import com.example.domain.dto.task.TaskDto;
import com.example.domain.entities.Task;
import com.example.domain.enuns.StatusTask;
import com.example.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository repository;

    public TaskService(TaskRepository repository){
        this.repository = repository;
    }

    public List<TaskDto> listAll(){
        return convertListTaskToListTaskDto(repository.findAll());
    }

    public TaskDto findById(Long id){
        Optional<Task> op = repository.findById(id);

        if(op.isPresent()){
            return convertTaskToTaskDto(op.get());
        }

        throw new RuntimeException("Task not found");
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

    private List<TaskDto> convertListTaskToListTaskDto(List<Task> entity){
        List<TaskDto> dto =  new ArrayList<>();
        for(Task t : entity){
            dto.add(convertTaskToTaskDto(t));
        }
        return dto;
    }

    private TaskDto convertTaskToTaskDto(Task task){
        return new TaskDto(task.getId(),task.getTitle(),task.getDescription(),task.getStatus(),task.getCreatedAt());
    }

}
