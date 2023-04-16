package com.optimize.jpademoapp.student.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateStudentDTO {
    @NotNull(message = "First name should not be null")
    private String firstName;
    @NotNull(message = "Last name should not be null")
    private String lastName;
    @NotNull(message = "Email name should not be null")
    @Email(message = "Email must be a valid email")
    private String email;
    @NotNull(message = "Age should not be null")
    @Min(18)
    @Max(50)
    private Integer age;
}
