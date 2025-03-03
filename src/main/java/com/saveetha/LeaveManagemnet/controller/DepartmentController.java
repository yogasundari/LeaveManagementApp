package com.saveetha.LeaveManagemnet.controller;

import com.saveetha.LeaveManagemnet.entity.Department;
import com.saveetha.LeaveManagemnet.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable int id, @RequestBody Department updatedDepartment) {
        return departmentService.updateDepartment(id, updatedDepartment);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
        return "Department deleted successfully!";
    }
}
