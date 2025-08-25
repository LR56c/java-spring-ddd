package com.example.java_spring_ddd.application;

import com.example.java_spring_ddd.domain.User;
import com.example.java_spring_ddd.infrastructure.UserEntity;
import com.example.java_spring_ddd.infrastructure.UserMapper;
import com.example.java_spring_ddd.infrastructure.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateUser {
    private final UserRepository repo;

    public CreateUser(UserRepository repo) {
        this.repo = repo;
    }

    public UserDTO execute(UserDTO dto) {
        if (repo.existsById(dto.id())) {
            throw new IllegalArgumentException("User with id '" + dto.id() + "' already exists.");
        }
        User user = User.from(
                dto.id(),
                dto.name(),
                dto.email(),
                LocalDateTime.now()
        );
        repo.save(UserMapper.toEntity(user));
        return UserMapper.toDTO(user);
    }
}
