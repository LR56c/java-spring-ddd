package com.example.java_spring_ddd.infrastructure;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public record PostEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        String id,
        @Column(name = "title", nullable = false)
        String title,
        @Column(name = "content", nullable = false)
        String content,
        @Column(name = "created_at", nullable = false)
        LocalDateTime createdAt,
        @ManyToOne
        @JoinColumn(name = "user_id", nullable = false)
        UserEntity user
) {
}
