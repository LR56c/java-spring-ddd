package com.example.java_spring_ddd.infrastructure;

import com.example.java_spring_ddd.application.UserDTO;
import com.example.java_spring_ddd.domain.User;

public class UserMapper {
    public static UserEntity toEntity(User user) {
        return new UserEntity(
                user.getId(),
                user.getName(),
                user.getEmail().getValue(),
                user.getCreatedA()
        );
    }

    public static User toDomain(UserEntity userEntity) {
        return User.from(
                userEntity.getId(),
                userEntity.getName(),
                userEntity.getEmail(),
                userEntity.getCreatedAt()
        );
    }

    public static UserDTO toDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail().getValue()
        );
    }
}
