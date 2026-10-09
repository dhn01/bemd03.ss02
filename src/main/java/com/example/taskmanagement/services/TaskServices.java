package com.example.taskmanagement.services;

import com.example.taskmanagement.models.Task;
import com.example.taskmanagement.models.User;
import com.example.taskmanagement.repositories.TaskRepository;
import com.example.taskmanagement.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class TaskServices {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public List<Task> findAllTasks(String search) {
        return taskRepository.findAll(search);
    }

    public Task createTask(Task task) {
        User user = userRepository.findById(task.getAssignedTo());
        if (user == null) {
            return  null;
        }
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        User user = userRepository.findById(task.getAssignedTo());
        if (user == null) {
            return  null;
        }
        return taskRepository.save(id, task);
    }

    public Task deleteTaskById(Long id) {
        return taskRepository.deleteById(id);
    }
}
