package com.dynamicdoers.hwapp.repository;

import com.dynamicdoers.hwapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
