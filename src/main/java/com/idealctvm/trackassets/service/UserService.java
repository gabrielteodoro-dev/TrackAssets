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
}
