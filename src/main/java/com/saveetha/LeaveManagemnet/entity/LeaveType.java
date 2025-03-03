package com.saveetha.LeaveManagemnet.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "LeaveType")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer leaveTypeId;

    @Column(nullable = false, length = 50)
    private String typeName;

    @Column(nullable = false)
    private Integer maxAllowedPerYear;

    @Column(nullable = false)
    private Integer maxAllowedPerMonth;

    @Column(nullable = false)
    private Integer minAllowedDays;

    private LocalDate academicYearStart;
    private LocalDate academicYearEnd;

    @Column(nullable = false)
    private Boolean canBeCarriedForward = false;

    private Integer maxCarryForward = 0;

    @Column(nullable = false)
    private Boolean active = true; // New field to indicate if leave type is active

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
