package com.dynamicdoers.hwapp.repository;

import com.dynamicdoers.hwapp.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
