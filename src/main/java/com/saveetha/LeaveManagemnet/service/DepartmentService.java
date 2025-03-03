package com.saveetha.LeaveManagemnet.service;

import com.saveetha.LeaveManagemnet.entity.Department;
import com.saveetha.LeaveManagemnet.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(int id, Department updatedDepartment) {
        return departmentRepository.findById(id).map(department -> {
            department.setDeptName(updatedDepartment.getDeptName());
            department.setDeptType(updatedDepartment.getDeptType());
            return departmentRepository.save(department);
        }).orElseThrow(() -> new RuntimeException("Department not found!"));
    }

    public void deleteDepartment(int id) {
        departmentRepository.deleteById(id);
    }
}
