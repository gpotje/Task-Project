package com.example.repository;

import com.example.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskRepository extends JpaRepository<Task,Long> {
    Page<Task> findAll(Pageable pageable);
}
