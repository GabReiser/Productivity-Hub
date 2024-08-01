package com.application.ProductivityHub.repository;

import com.application.ProductivityHub.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    User findByUsername(String username);

}