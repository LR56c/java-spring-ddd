package com.example.java_spring_ddd.application;

import com.example.java_spring_ddd.domain.User;
import com.example.java_spring_ddd.infrastructure.UserMapper;
import com.example.java_spring_ddd.infrastructure.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UpdateUser {
    private final UserRepository repo;

    public UpdateUser(UserRepository repo) {
        this.repo = repo;
    }

    public UserDTO execute(UserDTO userDTO) {
        var userEntity = repo.findById(userDTO.id());
        if (userEntity.isEmpty()) {
            throw new IllegalArgumentException("User with id '" + userDTO.id() + "' does not exist.");
        }
        User user = User.from(
                userEntity.get().getId(),
                userDTO.name(),
                userDTO.email(),
                userEntity.get().getCreatedAt()
        );
        repo.save(UserMapper.toEntity(user));
        return UserMapper.toDTO(user);
    }
}
