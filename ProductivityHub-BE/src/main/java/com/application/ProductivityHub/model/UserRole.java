package com.application.ProductivityHub.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum UserRole {
    ADMIN("admin"),
    USER("user");

    private String role;
}
