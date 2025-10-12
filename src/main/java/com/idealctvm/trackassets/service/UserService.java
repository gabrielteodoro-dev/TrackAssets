package com.idealctvm.trackassets.service;

import com.idealctvm.trackassets.model.User;
import com.idealctvm.trackassets.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name) {
        return userRepository.save(new User(name));
    }

    public List<?> findAll() {
        return userRepository.findAll();
    }

    public void deleteUser(Long userId) {
        if(!userRepository.existsById(userId)){
            throw new RuntimeException("User not found with ID: " + userId);
        }
        userRepository.deleteById(userId);
    }
}
