package com.example.java_spring_ddd.infrastructure;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "posts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {
    @Id
    UUID id;
    @Column(name = "title", nullable = false)
    String title;
    @Column(name = "content", nullable = false)
    String content;
    @Column(name = "created_at", nullable = false)
    LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    UserEntity user;
}
