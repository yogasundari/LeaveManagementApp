package com.saveetha.LeaveManagement.enums;

public enum Role {
    ROLE_EMPLOYEE,
    ROLE_ADMIN;
    public static Role fromString(String role) {
        for (Role r : Role.values()) {
            if (r.name().equalsIgnoreCase(role)) {
                return r;
            }
        }
        throw new IllegalArgumentException("Invalid role: " + role);
    }
}
