package com.saveetha.LeaveManagement.service;

import com.saveetha.LeaveManagement.entity.Department;
import com.saveetha.LeaveManagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    // Create a new department
    public Department createDepartment(Department department) {
        if (departmentRepository.findByDeptName(department.getDeptName()).isPresent()) {
            throw new RuntimeException("Department already exists.");
        }
        return departmentRepository.save(department);
    }

    // Get all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Get department by ID
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.findById(id);
    }

    // Update a department
    public Department updateDepartment(Long id, Department updatedDept) {
        return departmentRepository.findById(id).map(dept -> {
            dept.setDeptName(updatedDept.getDeptName());
            dept.setDeptType(updatedDept.getDeptType());
            dept.setActive(updatedDept.isActive());
            return departmentRepository.save(dept);
        }).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    // Delete a department
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
