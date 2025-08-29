package com.example.java_spring_ddd.application;


import com.example.java_spring_ddd.infrastructure.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final CreateUser createUser;
    private final DeleteUser deleteUser;
    private final UpdateUser updateUser;
    private final SearchUser searchUser;


    @Autowired
    public UserService(CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser, SearchUser searchUser) {
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
        this.searchUser = searchUser;
    }

    public UserDTO save(UserDTO user) {
        return createUser.execute(user);
    }

    public void delete(String id) {
        deleteUser.execute(id);
    }

    public Page<UserDTO> findAll(@RequestParam Map<String, String> query, Pageable pageable) {
        return searchUser.execute(query, pageable);
    }

    public UserDTO update(UserDTO user) {
        return updateUser.execute(user);
    }
}
