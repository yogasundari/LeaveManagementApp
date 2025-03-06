package com.saveetha.LeaveManagement.controller;

import com.saveetha.LeaveManagement.entity.Department;
import com.saveetha.LeaveManagement.repository.DepartmentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Create Department (Admin Only)
    @PostMapping("/create")
    public ResponseEntity<String> createDepartment(@RequestBody Department department, Authentication authentication) {
        // Ensure only ADMIN users create departments
        if (!authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN"))) {
            return ResponseEntity.status(403).body("Access Denied: Only Admins can create departments.");
        }

        departmentRepository.save(department);
        return ResponseEntity.ok("Department created successfully!");
    }

    // Get All Departments
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return ResponseEntity.ok(departmentRepository.findAll());
    }
}
