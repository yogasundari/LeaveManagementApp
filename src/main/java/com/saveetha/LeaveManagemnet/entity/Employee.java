package com.saveetha.LeaveManagemnet.entity;

import com.saveetha.LeaveManagemnet.enums.Role;
import com.saveetha.LeaveManagemnet.enums.StaffType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @Column(length = 10, nullable = false)
    private String empId; // Employee ID

    @Column(nullable = true, length = 100)
    private String empName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    private String designation;

    @ManyToOne
    @JoinColumn(name = "dept_id", nullable = true) // Department is nullable during registration
    private Department department;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role = Role.EMPLOYEE; // Default role: EMPLOYEE

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    private StaffType staffType;

    private String profilePicture;

    @ManyToOne
    @JoinColumn(name = "approval_flow_id", nullable = true)
    private ApprovalFlow approvalFlow;

    private Timestamp lastLogin;

    @Column(nullable = false)
    private boolean active = true; // Default: Employee is active

    private Timestamp createdAt;
    private Timestamp updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = new Timestamp(System.currentTimeMillis());
        updatedAt = createdAt;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Timestamp(System.currentTimeMillis());
    }
}
