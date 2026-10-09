package com.example.taskmanagement.services;

import com.example.taskmanagement.models.User;
import com.example.taskmanagement.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepository userRepository;

    public List<User> findAllUsers(String search) {
        return userRepository.findAll(search);
    }

    public User findUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        return userRepository.save(id, user);
    }

    public User deleteUserById(Long id) {
        return userRepository.deleteById(id);
    }
}
