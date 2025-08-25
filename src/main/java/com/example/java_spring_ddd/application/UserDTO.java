package com.example.java_spring_ddd.application;

import java.util.UUID;

public record UserDTO(
        UUID id,
        String name,
        String email
) {
}
