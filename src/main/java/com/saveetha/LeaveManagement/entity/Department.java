package com.saveetha.LeaveManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "department")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dept_id")
    private Long departmentId;

    @Column(nullable = false, unique = true) // Department name should not be null
    private String deptName;  // Changed from Enum to String

    @Column(nullable = false)
    private String deptType;  // Changed from Enum to String

    @Column(nullable = false)
    private boolean active = true; // Default: Department is active

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}
