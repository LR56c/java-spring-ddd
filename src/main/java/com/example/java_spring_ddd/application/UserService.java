package com.example.java_spring_ddd.application;


import com.example.java_spring_ddd.domain.User;
import com.example.java_spring_ddd.infrastructure.UserEntity;
import com.example.java_spring_ddd.infrastructure.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final CreateUser createUser;

    @Autowired
    public UserService(UserRepository userRepository, CreateUser createUser) {
        this.userRepository = userRepository;
        this.createUser = createUser;
    }

    public UserDTO save(UserDTO user) {
        return createUser.execute(user);
    }

    public void delete(UserEntity user) {
        userRepository.delete(user);
    }

    public Iterable<UserEntity> findAll() {
        return userRepository.findAll();
//        var entities = postRepositoryData.findAll();
//        return StreamSupport.stream(entities.spliterator(), false)
//                .map(UserUserEntityDataMapper::toDomain)
//                .toList();
    }

    public Optional<UserEntity> findById(String id) {
        return userRepository.findById(id);
    }
}
