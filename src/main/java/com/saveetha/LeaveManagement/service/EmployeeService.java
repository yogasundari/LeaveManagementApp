package com.saveetha.LeaveManagement.service;

import com.saveetha.LeaveManagement.dto.EmployeeUpdateDTO;
import com.saveetha.LeaveManagement.entity.Department;
import com.saveetha.LeaveManagement.entity.Employee;
import com.saveetha.LeaveManagement.repository.DepartmentRepository;
import com.saveetha.LeaveManagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void updateProfile(String email, EmployeeUpdateDTO updateDTO) {
        Optional<Employee> employeeOptional = employeeRepository.findByEmail(email);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            if (updateDTO.getEmpName() != null) {
                employee.setEmpName(updateDTO.getEmpName());
            }
            if (updateDTO.getDesignation() != null) {
                employee.setDesignation(updateDTO.getDesignation());
            }
            if (updateDTO.getDepartmentId() != null) {
                // Assuming department fetch logic is handled elsewhere
            }
            if (updateDTO.getStaffType() != null) {
                employee.setStaffType(updateDTO.getStaffType());
            }
            if (updateDTO.getProfilePicture() != null) {
                employee.setProfilePicture(updateDTO.getProfilePicture()); // Base64 or file URL
            }

            employeeRepository.save(employee);
        } else {
            throw new RuntimeException("Employee not found");
        }
    }
}
