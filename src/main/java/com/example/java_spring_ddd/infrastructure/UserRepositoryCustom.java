package com.example.java_spring_ddd.infrastructure;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface UserRepositoryCustom {
    Page<UserEntity> search(Map<String, String> query, Pageable pageable);
}
