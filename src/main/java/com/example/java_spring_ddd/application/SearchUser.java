package com.example.java_spring_ddd.application;

import com.example.java_spring_ddd.infrastructure.UserEntity;
import com.example.java_spring_ddd.infrastructure.UserMapper;
import com.example.java_spring_ddd.infrastructure.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Component
public class SearchUser {
    private final UserRepository repo;

    public SearchUser(UserRepository repo) {
        this.repo = repo;
    }

    public Page<UserDTO> execute(
            @RequestParam Map<String, String> query, Pageable pageable) {
        return repo.search(query, pageable)
                .map(e -> UserMapper.toDTO(UserMapper.toDomain(e)));
    }
}
