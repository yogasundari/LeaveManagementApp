package com.saveetha.LeaveManagement.dto;

import com.saveetha.LeaveManagement.enums.StaffType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeUpdateDTO {
    private String empName;
    private String designation;
    private Long departmentId;
    private StaffType staffType;
    private String profilePicture; // Store as Base64 or file URL
}
