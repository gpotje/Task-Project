package com.example.controller;

import com.example.domain.dto.CreateTaskRequestDto;
import com.example.domain.dto.CreateTaskResponseDto;
import com.example.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateTaskResponseDto> createTask(@RequestBody CreateTaskRequestDto dto){
        return new ResponseEntity<CreateTaskResponseDto>(service.createTask(dto), HttpStatus.CREATED);
    }
}
