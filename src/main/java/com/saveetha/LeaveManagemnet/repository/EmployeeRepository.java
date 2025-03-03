package com.saveetha.LeaveManagemnet.repository;

import com.saveetha.LeaveManagemnet.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    Optional<Employee> findByEmail(String email);
    boolean existsByEmail(String email);
}
