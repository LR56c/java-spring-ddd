package com.example.java_spring_ddd.application;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<UserDTO> findAll() {
        return searchUser.execute();
    }

    public UserDTO update(UserDTO user) {
        return updateUser.execute(user);
    }
}
