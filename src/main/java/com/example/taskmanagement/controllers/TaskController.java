package com.example.taskmanagement.controllers;

import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.services.TaskServices;
import com.example.taskmanagement.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskServices taskServices;
    private final UserServices userServices;

    @GetMapping("")
    public ResponseEntity<List<Task>> getAllTasks(@RequestParam(name = "search", defaultValue = "") String search) {
        return ResponseEntity.ok(taskServices.findAllTasks(search));
    }

    @PostMapping("")
    public ResponseEntity<Task> addTask(@RequestBody Task task) {
        return ResponseEntity
                .status(taskServices.createTask(task) == null
                        ? HttpStatus.BAD_REQUEST
                        : HttpStatus.CREATED)
                .body(task);
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return ResponseEntity
                .status(taskServices.updateTask(taskId, task) == null
                        ? HttpStatus.NOT_FOUND
                        : HttpStatus.OK)
                .body(task);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        Task deleted = taskServices.deleteTaskById(taskId);
        if (deleted == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
