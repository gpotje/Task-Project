package com.example.domain.entities;

import com.example.domain.enuns.StatusTask;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "tb_task")
public class Task {

    @Id
    private Long id;
    private String title;
    private String description;
    private StatusTask status;
    private Date createdAt;

    public Task() {}
}
