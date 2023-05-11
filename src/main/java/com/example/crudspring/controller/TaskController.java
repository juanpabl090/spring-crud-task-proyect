package com.example.crudspring.controller;


import com.example.crudspring.entities.Task;
import com.example.crudspring.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    public TaskController() {
    }

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/api/task")
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @GetMapping("/api/task/{id}")
    public Optional<Task> getTaskbyid(@PathVariable Long id) {
        return taskRepository.findById(id);
    }

    @PostMapping("/api/task")
    public Task create(@RequestBody Task task, @RequestHeader HttpHeaders headers) {
        return taskRepository.save(task);
    }

    @PutMapping("/api/task")
    public ResponseEntity update(@RequestBody Task task) {
        if (task.getId() == null && !taskRepository.existsById(task.getId()))
            return ResponseEntity.badRequest().build();
        Task result = taskRepository.save(task);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/api/task/{id}")
    public ResponseEntity<Task> deleteById(@PathVariable Long id) {
        if (!taskRepository.existsById(id))
            return ResponseEntity.notFound().build();
        taskRepository.deleteById(id);
        return ResponseEntity.notFound().build();
    }
}
