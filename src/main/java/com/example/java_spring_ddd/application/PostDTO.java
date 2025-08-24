package com.example.java_spring_ddd.application;

public record PostDTO(
        String id,
        String title,
        String content,
        UserDTO user,
        String createdAt
) {
}
