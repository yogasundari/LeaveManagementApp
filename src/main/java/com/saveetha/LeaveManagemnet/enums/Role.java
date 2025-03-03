package com.saveetha.LeaveManagemnet.enums;

public enum Role {
    EMPLOYEE,
    ADMIN;

    public static Role fromString(String role) {
        return Role.valueOf(role.toUpperCase());  // Convert to uppercase before matching
    }
}
