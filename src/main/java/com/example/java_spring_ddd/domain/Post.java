package com.example.java_spring_ddd.domain;

import java.time.LocalDateTime;


public final class Post{
    final String id;
    final String title;
    final String content;
    final LocalDateTime createdAt;
    final User user;

    public Post(String id, String title, String content, LocalDateTime createdAt, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
    }

    public static Post from(String id, String title, String content, LocalDateTime createdAt, User user) {
        return new Post(id, title, content, createdAt, user);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getUser() {
        return user;
    }
}
