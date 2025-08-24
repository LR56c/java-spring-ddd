package com.example.java_spring_ddd.controller;
import com.example.java_spring_ddd.application.UserDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.java_spring_ddd.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUsers() {
        return "Hello, World!";
    }

    @PostMapping("/users")
    public UserDTO createUser(@RequestBody @Validated  UserDTO user) {
        return userService.save(user);
    }
}


