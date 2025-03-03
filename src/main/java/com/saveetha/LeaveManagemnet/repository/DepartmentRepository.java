package com.saveetha.LeaveManagemnet.repository;

import com.saveetha.LeaveManagemnet.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
