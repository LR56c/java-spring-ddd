package com.example.java_spring_ddd.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
public final class Post{
    final UUID id;
    final String title;
    final String content;
    final LocalDateTime createdAt;
    final User user;

    private Post(UUID id, String title, String content, LocalDateTime createdAt, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
    }

    public static Post from(UUID id, String title, String content, LocalDateTime createdAt, User user) {
        return new Post(id, title, content, createdAt, user);
    }
}
