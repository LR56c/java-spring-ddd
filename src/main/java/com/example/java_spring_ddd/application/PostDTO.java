package com.example.java_spring_ddd.application;

import java.util.UUID;

public record PostDTO(
        UUID id,
        String title,
        String content,
        UserDTO user,
        String createdAt
) {
}
