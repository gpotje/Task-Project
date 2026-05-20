package com.example.controller;

import com.example.domain.dto.task.CreateTaskRequestDto;
import com.example.domain.dto.CreateResponseDto;
import com.example.domain.dto.task.TaskDto;
import com.example.domain.dto.task.UpdateStatusRequestDto;
import com.example.domain.dto.task.UpdateStatusTaskDto;
import com.example.domain.entities.Task;
import com.example.domain.enuns.StatusTask;
import com.example.exception.TaskNotFoundException;
import com.example.service.TaskService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    private TaskService service;

    public TaskController(TaskService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateResponseDto> createTask(@RequestBody CreateTaskRequestDto dto){
        return new ResponseEntity<>(service.createTask(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> listAll(){
        return new ResponseEntity<>(service.listAll(),HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDto> findById(@PathVariable Long id){
        return new ResponseEntity<>(service.findById(id),HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}/status")
    public ResponseEntity<CreateResponseDto> findById(@PathVariable Long id, @RequestBody UpdateStatusRequestDto dto){
        return new ResponseEntity<>(service.UpdateStatusTask(new UpdateStatusTaskDto(id,dto.getStatus())),HttpStatus.OK);
    }




}
