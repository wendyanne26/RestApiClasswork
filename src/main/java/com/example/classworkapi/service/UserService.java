package com.example.classworkapi.service;

import com.example.classworkapi.model.Users;

public interface UserService {
    Users createUser(Users users);

    Users loginUser(Users users);

    void deleteUser(Long userId);

    Users updateUser(Long userId, Users users);
}
