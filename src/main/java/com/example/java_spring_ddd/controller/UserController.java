package com.example.java_spring_ddd.controller;

import com.example.java_spring_ddd.application.UserDTO;
import com.example.java_spring_ddd.application.UserService;
import com.example.java_spring_ddd.domain.User;
import com.example.java_spring_ddd.infrastructure.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public ResponseEntity<Page<UserDTO>> search(@RequestParam Map<String, String> query, Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(query, pageable));
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
