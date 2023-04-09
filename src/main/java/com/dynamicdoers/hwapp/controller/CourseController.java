package com.dynamicdoers.hwapp.controller;

import com.dynamicdoers.hwapp.model.Course;
import com.dynamicdoers.hwapp.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping(path = "/{id}")
    public Optional<Course> getSpecificCourse(@PathVariable int id){
        return courseService.getSpecificCourse(id);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course courseToCreate){
        return courseService.registerCourse(courseToCreate);
    }

    @PutMapping(path = "/{id}")
    public Optional<Course> updateCourse(@PathVariable int id, @RequestBody Course upToDateCourse){
        return courseService.updateCourse(id, upToDateCourse);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteSpecificCourse(@PathVariable int id){
        courseService.dropSpecificCourse(id);
    }
}
