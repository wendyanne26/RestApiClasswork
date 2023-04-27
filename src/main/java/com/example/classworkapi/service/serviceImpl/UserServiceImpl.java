package com.example.classworkapi.service.serviceImpl;

import com.example.classworkapi.model.Users;
import com.example.classworkapi.repositories.UserRepository;
import com.example.classworkapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepo;
    @Autowired
    public UserServiceImpl(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Users createUser(Users users) {
        Users users1 = new Users();
        users1.setEmail(users.getEmail());
         users1.setUsername(users.getUsername());
         users1.setPhone(users.getPhone());
         users1.setCreatedAt(LocalDateTime.now());
         users1.setUpdatedAt(LocalDateTime.now());
         users1.setPassword(users.getPassword());
        Users newUser = userRepo.save(users1);
        return newUser;
    }

    @Override
    public Users loginUser(Users users) {
        Users users1 = userRepo.findByUsername(users.getUsername()).get();
        return users1;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepo.deleteById(userId);
    }

    @Override
    public Users updateUser(Long userId, Users users) {
        Users users1 = userRepo.findById(userId).get();
        users1.setUsername(users.getUsername());
        Users updatedUser = userRepo.save(users1);
        return updatedUser;
    }
}
