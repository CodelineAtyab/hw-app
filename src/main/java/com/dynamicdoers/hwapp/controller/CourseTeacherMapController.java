package com.dynamicdoers.hwapp.controller;

import com.dynamicdoers.hwapp.model.CourseTeacherMap;
import com.dynamicdoers.hwapp.repository.CourseTeacherMapRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/courseTeacherMapping")
public class CourseTeacherMapController {
    @Autowired
    CourseTeacherMapRepository courseTeacherMapRepository;

    @GetMapping
    public List<CourseTeacherMap> getCourseTeacherMappings() {
        return courseTeacherMapRepository.getCourseTeacherMappings();
    }
}
