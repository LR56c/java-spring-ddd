package com.example.java_spring_ddd.application;

import com.example.java_spring_ddd.infrastructure.UserRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Component
public class SearchUser {
    private final UserRepository repo;

    public SearchUser(UserRepository repo) {
        this.repo = repo;
    }

    public List<UserDTO> execute(
            @RequestParam Map<String, String> query, Pageable pageable) {
        var users = repo.search(query, pageable);
        return users.stream()
                .map(user -> new UserDTO(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .toList();
    }
}
