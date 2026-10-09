package com.example.taskmanagement.repositories;

import com.example.taskmanagement.models.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Repository
public class TaskRepository {
    private final List<Task> tasks = new ArrayList<>(
            Arrays.asList(
                    new Task(1L, "Học Java", "Ôn Java Core", "high", 1L),
                    new Task(2L, "Học Spring", "Học Spring Boot", "high", 2L),
                    new Task(3L, "Học Git", "Ôn Git", "medium", 1L),
                    new Task(4L, "Làm REST API", "Tạo API", "high", 1L),
                    new Task(5L, "Thiết kế DB", "Thiết kế database", "high", 1L),
                    new Task(6L, "Viết Controller", "Tạo Controller", "medium", 3L),
                    new Task(7L, "Viết Service", "Tạo Service", "high", 3L),
                    new Task(8L, "Viết Repository", "Tạo Repository", "low", 2L),
                    new Task(9L, "Test API", "Test bằng Postman", "medium", 3L),
                    new Task(10L, "Push GitHub", "Đẩy project lên GitHub", "high", 2L)

            )
    );

    public List<Task> findAll(String search) {
        if (search == null || search.isBlank()) {
            return tasks;
        }
        return tasks.stream()
                .filter(t -> t.getTitle().contains(search))
                .toList();
    }

    public Task findById(Long id) {
        return tasks.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Task save(Task task) {
        Long nextId = tasks.stream()
                .max(Comparator.comparing(Task::getId))
                .map(Task::getId)
                .orElse(0L) + 1;

        task.setId(nextId);
        tasks.add(task);
        return task;
    }

    public Task save(Long id, Task task) {
        Task existing = findById(id);
        if (existing == null) {
            return null;
        }
        existing.setTitle(task.getTitle());
        existing.setDescription(task.getDescription());
        existing.setAssignedTo(task.getAssignedTo());
        existing.setPriority(task.getPriority());
        return existing;
    }

    public Task deleteById(Long id) {
        Task target = findById(id);
        if (target == null) {
            return null;
        }
        tasks.remove(target);
        return target;
    }
}
