package com.application.ProductivityHub.service;

import com.application.ProductivityHub.model.User;
import com.application.ProductivityHub.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    public User findById(String id) {
        return userRepository.findById(id).orElse(null);
    }
}

