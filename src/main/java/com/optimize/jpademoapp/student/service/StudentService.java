package com.optimize.jpademoapp.student.service;

import com.optimize.jpademoapp.student.dto.CreateStudentDTO;
import com.optimize.jpademoapp.student.dto.UpdateStudentDTO;
import com.optimize.jpademoapp.student.entity.Student;
import com.optimize.jpademoapp.student.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public Student createStudent (CreateStudentDTO createStudentDTO) {
        Student student = new Student();
        student.setFirstName(createStudentDTO.getFirstName());
        student.setLastName(createStudentDTO.getLastName());
        student.setEmail(createStudentDTO.getEmail());
        student.setAge(createStudentDTO.getAge());
        return this.studentRepository.save(student);
    }
    public List<Student> findAll (){
        return this.studentRepository.findAll();
    }
    public Student findOne(Long id) {
        Student  student = this.findStudentById(id);
        return student;
    }
    public void updateStudent(Long id, UpdateStudentDTO updateStudentDTO) {
        Student student = this.findStudentById(id);
        updateStudentDTO.getFirstName().ifPresent(student::setFirstName);
        updateStudentDTO.getLastName().ifPresent(student::setLastName);
        updateStudentDTO.getEmail().ifPresent(student::setEmail);
        updateStudentDTO.getAge().ifPresent(student::setAge);
        this.studentRepository.save(student);
    }
    public void deleteStudent(Long id) {
        Student student = this.findStudentById(id);
        this.studentRepository.deleteById(student.getId());
    }
    public Student findStudentById (Long id) {
        Student  student = this.studentRepository.findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException(
                                "Student with ID: ".concat(Long.toString(id).concat(" not found."))
                        )
                );
        return student;
    }
}
