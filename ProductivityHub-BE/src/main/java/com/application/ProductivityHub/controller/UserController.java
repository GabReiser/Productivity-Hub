package com.application.ProductivityHub.controller;

import com.application.ProductivityHub.model.User;
import com.application.ProductivityHub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping
    public ResponseEntity<String> getUser(){
        return ResponseEntity.ok("Sucesso!");
    }
    @GetMapping("/getAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }
    @GetMapping("/getUserById")    public ResponseEntity<User>getUserById(String id){
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
}