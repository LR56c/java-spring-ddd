package com.example.java_spring_ddd.application;


import com.example.java_spring_ddd.infrastructure.PostRepository;
import com.example.java_spring_ddd.infrastructure.PostEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PostRepository postRepository;

    public PostEntity save(PostEntity user) {
        return postRepository.save(user);
    }

    public void delete(PostEntity user) {
        postRepository.delete(user);
    }

    public Iterable<PostEntity> findAll() {
        return postRepository.findAll();
    }

    public Optional<PostEntity> findById(String id) {
        return postRepository.findById(id);
    }
}
