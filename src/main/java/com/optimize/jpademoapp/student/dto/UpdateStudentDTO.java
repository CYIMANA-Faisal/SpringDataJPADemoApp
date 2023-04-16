package com.optimize.jpademoapp.student.dto;

import lombok.Data;
import java.util.Optional;

@Data
public class UpdateStudentDTO {
    private Optional<String> firstName = Optional.empty();
    private Optional<String> lastName = Optional.empty();
    private Optional<String> email = Optional.empty();
    private Optional<Integer> age = Optional.empty();
}
