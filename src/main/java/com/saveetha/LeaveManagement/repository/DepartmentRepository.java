package com.saveetha.LeaveManagement.repository;

import com.saveetha.LeaveManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDeptName(String deptName);
}
