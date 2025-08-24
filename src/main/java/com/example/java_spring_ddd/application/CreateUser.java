package com.example.java_spring_ddd.application;

import com.example.java_spring_ddd.domain.User;
import com.example.java_spring_ddd.infrastructure.UserEntity;
import com.example.java_spring_ddd.infrastructure.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CreateUser {
    private final UserRepository repo;
    private final ModelMapper modelMapper;

    public CreateUser(UserRepository repo, ModelMapper modelMapper) {
        this.repo = repo;
        this.modelMapper = modelMapper;
    }

    public UserDTO execute(UserDTO dto) {
        User user = User.from(
                dto.id(),
                dto.name(),
                dto.email(),
                LocalDateTime.now()
        );
        UserEntity entity = new UserEntity(
                user.getId(),
                user.getName(),
                user.getEmail().toString(),
                user.getCreatedA()
        );
        repo.save(entity);
        return modelMapper.map(entity, UserDTO.class);
    }
}
