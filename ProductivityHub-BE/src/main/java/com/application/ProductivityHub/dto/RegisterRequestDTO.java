package com.application.ProductivityHub.dto;

import com.application.ProductivityHub.model.UserRole;

public record RegisterRequestDTO(String username, String email, String password, UserRole role) {
}
