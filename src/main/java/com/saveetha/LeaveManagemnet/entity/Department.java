package com.saveetha.LeaveManagemnet.entity;

import com.saveetha.LeaveManagemnet.enums.DepartmentName;
import com.saveetha.LeaveManagemnet.enums.DeptType;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, unique = true) // Department name should not be null
    private DepartmentName deptName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeptType deptType;

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
