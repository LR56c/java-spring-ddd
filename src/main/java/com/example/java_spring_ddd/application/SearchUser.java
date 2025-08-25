package com.example.java_spring_ddd.application;

import com.example.java_spring_ddd.infrastructure.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.StreamSupport;

@Component
public class SearchUser {
    private final UserRepository repo;

    public SearchUser(UserRepository repo) {
        this.repo = repo;
    }

    public List<UserDTO> execute() {
        var users = StreamSupport
                .stream(repo.findAll().spliterator(), false)
                .toList();
        return users.stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .toList();
    }
}
