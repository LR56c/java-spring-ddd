package com.example.java_spring_ddd.controller;

import com.example.java_spring_ddd.application.UserDTO;
import com.example.java_spring_ddd.application.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping()
    public UserDTO createUser(@RequestBody UserDTO user) {
        return userService.save(user);
    }

    @GetMapping()
    public List<UserDTO> findAll() {
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.delete(id);
    }

    @PutMapping()
    public UserDTO updateUser(@RequestBody UserDTO user) {
        return userService.update(user);
    }
}
