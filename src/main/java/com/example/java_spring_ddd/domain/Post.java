package com.example.java_spring_ddd.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "posts")
public record Post(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id,
        @Column(name = "title", nullable = false)
        String title,
        @Column(name = "content", nullable = false)
        String content,
        @Column(name = "author_id", nullable = false)
        Long authorId
) {
}
