package com.gabrielteodoro.trackassets.controller;


import com.gabrielteodoro.trackassets.model.User;
import com.gabrielteodoro.trackassets.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    // Create User
    @PostMapping()
    public User createUser(@RequestBody User user){
        return userService.createUser(user.getName());
    }

    // Display all users
    @GetMapping()
    public List<?> findAll(){
        return userService.findAll();
    }

    // Delete user
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
