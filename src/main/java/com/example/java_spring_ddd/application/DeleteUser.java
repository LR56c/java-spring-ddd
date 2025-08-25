package com.example.java_spring_ddd.application;

import com.example.java_spring_ddd.infrastructure.UserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DeleteUser {
    private final UserRepository repo;

    public DeleteUser(UserRepository repo) {
        this.repo = repo;
    }

    public void execute(String id) {
        var uuid = UUID.fromString(id);
        var user = repo.existsById(uuid);
        if (!user) {
            throw new IllegalArgumentException("User with id '" + id + "' does not exist.");
        }
        repo.deleteById(uuid);
    }
}
