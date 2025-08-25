package com.example.java_spring_ddd.domain;

import com.example.java_spring_ddd.shared.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public final class User {
    final UUID id;
    final String name;
    final Email email;
    final LocalDateTime createdA;

    private User(UUID id, String name, Email email, LocalDateTime createdA) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdA = createdA;
    }

    public static User from(UUID id, String name, String email, LocalDateTime createdAt) {
        return new User(id, name, Email.from(email), createdAt);
    }
}


