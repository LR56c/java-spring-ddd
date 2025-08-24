package com.example.java_spring_ddd.infrastructure;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public record UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        String id,
        @Column(name = "title", nullable = false)
        String name,
        @Column(name = "content", nullable = false)
        String email,
        @Column(name = "created_at", nullable = false)
        LocalDateTime createdAt
) {
}


