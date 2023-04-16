package com.optimize.jpademoapp.student.controller;

import com.optimize.jpademoapp.common.enums.ApiStatus;
import com.optimize.jpademoapp.common.response.ApiResponse;
import com.optimize.jpademoapp.student.dto.CreateStudentDTO;
import com.optimize.jpademoapp.student.dto.UpdateStudentDTO;
import com.optimize.jpademoapp.student.entity.Student;
import com.optimize.jpademoapp.student.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ApiResponse<Student>> createStudent (@RequestBody @Valid CreateStudentDTO createStudentDTO) {
        Student createdStudent = this.studentService.createStudent(createStudentDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdStudent.getId()).toUri();
        return ResponseEntity.created(location).body(
            new ApiResponse(
                ApiStatus.SUCCESS,
                "Student created successfully",
                createdStudent
            )
        );
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse<List<Student>>> findAll () {
        return ResponseEntity.ok().body(
            new ApiResponse(
                ApiStatus.SUCCESS,
                "Students retrieved successfully",
                this.studentService.findAll()
            )
        );
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse<Student>> findOne (@PathVariable Long id) {
        Student student = this.studentService.findOne(id);
        return ResponseEntity.ok().body(
            new ApiResponse(
                ApiStatus.SUCCESS,
                "Student retrieved successfully",
                student
            )
        );
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse<Void>> updateStudent (@PathVariable Long id,@RequestBody UpdateStudentDTO updateStudentDTO) {
        this.studentService.updateStudent(id, updateStudentDTO);
        return ResponseEntity.ok().body(
            new ApiResponse(
                ApiStatus.SUCCESS,
                "Student updated successfully",
                null
            )
        );
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ApiResponse<Void>> deleteStudent (@PathVariable Long id) {
        this.studentService.deleteStudent(id);
        return ResponseEntity.ok().body(
            new ApiResponse(
                ApiStatus.SUCCESS,
                "Student deleted successfully",
                null
            )
        );
    }
}
