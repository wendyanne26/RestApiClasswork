package com.example.classworkapi.controller;

import com.example.classworkapi.model.Users;
import com.example.classworkapi.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody Users users){
        userService.createUser(users);
        return new ResponseEntity<>(users.getUsername(), HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Users users, HttpServletRequest request){
        userService.loginUser(users);
        request.setAttribute("UserId", users.getId());
        return new ResponseEntity<>(users.getUsername(), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("user deleted", HttpStatus.OK);
    }
    @PutMapping("update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId, Users users){
        userService.updateUser(userId, users);
        return new ResponseEntity<>("update successful", HttpStatus.OK);
    }
}
