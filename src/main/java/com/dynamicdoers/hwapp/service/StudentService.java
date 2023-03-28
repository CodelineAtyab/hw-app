package com.dynamicdoers.hwapp.service;

import com.dynamicdoers.hwapp.model.Student;
import com.dynamicdoers.hwapp.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudent(int id) {
        return studentRepository.findById(id);
    }

    public Student createStudent(Student currStudent) {
        return studentRepository.save(currStudent);
    }

    public Student updateStudent(int id, Student currStudent) {
        // Find the existing student
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            // Update the student
            Student updatedStudent = existingStudent.get();
            updatedStudent.name = currStudent.name;
            updatedStudent.email = currStudent.email;
            return studentRepository.save(updatedStudent);
        }
        return null;
    }

    public Student deleteStudent(int id) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()) {
            studentRepository.deleteById(id);
            return existingStudent.get();
        }
        return null;
    }
}
