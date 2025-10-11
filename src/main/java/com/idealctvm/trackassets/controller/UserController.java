package com.idealctvm.trackassets.controller;


import com.idealctvm.trackassets.model.User;
import com.idealctvm.trackassets.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping()
    public User createUser(@RequestBody User user){
        return userService.createUser(user.getName());
    }

    @GetMapping()
    public List<?> findAll(){
        return userService.findAll();
    }
}
