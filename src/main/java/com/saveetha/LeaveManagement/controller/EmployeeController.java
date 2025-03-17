package com.saveetha.LeaveManagement.controller;

import com.saveetha.LeaveManagement.dto.EmployeeUpdateDTO;
import com.saveetha.LeaveManagement.enums.StaffType;
import com.saveetha.LeaveManagement.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/update-profile")
    public ResponseEntity<?> updateProfile(
            @RequestParam("email") String email,
            @RequestParam(value = "empName", required = false) String empName,
            @RequestParam(value = "designation", required = false) String designation,
            @RequestParam(value = "departmentId", required = false) Long departmentId,
            @RequestParam(value = "staffType", required = false) StaffType staffType,
            @RequestPart(value = "profilePicture", required = false) MultipartFile profilePicture
    ) {
        try {
            String profilePictureString = null;

            // Convert image to Base64 (alternative: store file and save URL)
            if (profilePicture != null && !profilePicture.isEmpty()) {
                byte[] bytes = profilePicture.getBytes();
                profilePictureString = Base64.getEncoder().encodeToString(bytes);
            }

            EmployeeUpdateDTO updateDTO = new EmployeeUpdateDTO(empName, designation, departmentId, staffType, profilePictureString);
            employeeService.updateProfile(email, updateDTO);

            return ResponseEntity.ok("Profile updated successfully.");
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("File upload failed: " + e.getMessage());
        }
    }
}
