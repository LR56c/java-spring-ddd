package com.example.java_spring_ddd.controller;

import com.example.java_spring_ddd.application.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String getPosts() {
        return "Hello, World!";
    }
}


