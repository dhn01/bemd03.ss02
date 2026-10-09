package com.example.taskmanagement.repositories;

import com.example.taskmanagement.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Repository
public class UserRepository {
    private final List<User> users = new ArrayList<>(
            Arrays.asList(
                    new User(1L, "Nguyễn Văn A", "a@gmail.com", "USER"),
                    new User(2L, "Trần Nhân B", "b@gmail.com", "USER"),
                    new User(3L, "Hoàng Thị C", "c@gmail.com", "USER")
            )
    );

    public List<User> findAll(String search) {
        if  (search == null || search.isBlank()) {
            return users;
        }
        return users.stream()
                .filter(u -> u.getUsername().contains(search))
                .toList();
    }

    public User findById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User save(User user) {
        Long nextId = users.stream()
                .max(Comparator.comparing(User::getId))
                .map(User::getId)
                .orElse(0L) + 1;
        user.setId(nextId);
        users.add(user);
        return user;
    }

    public User save(Long id, User user) {
        User target = findById(id);
        if (target == null) {
            return null;
        }
        target.setUsername(user.getUsername());
        target.setEmail(user.getEmail());
        return target;
    }

    public User deleteById(Long id) {
        User target = findById(id);
        if (target == null) {
            return null;
        }
        users.remove(target);
        return target;
    }
}
