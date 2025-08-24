package com.example.java_spring_ddd.domain;

import com.example.java_spring_ddd.shared.Email;

import java.time.LocalDateTime;

public final class User {
    final String id;
    final String name;
    final Email email;
    final LocalDateTime createdA;

    private User(String id, String name, Email email, LocalDateTime createdA) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.createdA = createdA;
    }

    public static User from(String id, String name, String email, LocalDateTime createdAt) {
        return new User(id, name, Email.from(email), createdAt);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Email getEmail() {
        return email;
    }

    public LocalDateTime getCreatedA() {
        return createdA;
    }
}


