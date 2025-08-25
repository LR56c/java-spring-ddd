package com.example.java_spring_ddd.infrastructure;

import com.example.java_spring_ddd.domain.Post;

public class PostMapper {
    static PostEntity toEntity(Post post) {
        return new PostEntity(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                UserMapper.toEntity(post.getUser())
        );
    }

    static Post toDomain(PostEntity postEntity) {
        return Post.from(
                postEntity.getId(),
                postEntity.getTitle(),
                postEntity.getContent(),
                postEntity.getCreatedAt(),
                UserMapper.toDomain(postEntity.getUser())
        );
    }
}
