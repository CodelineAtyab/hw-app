package com.dynamicdoers.hwapp.service;

import com.dynamicdoers.hwapp.model.Course;
import com.dynamicdoers.hwapp.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public Optional<Course> getSpecificCourse(int id){
        return courseRepository.findById(id);
    }

    public Course registerCourse(Course courseToRegister){
        return courseRepository.save(courseToRegister);
    }

    public Optional<Course> updateCourse(int id, Course upToDateCourse){
        Optional<Course> optionalCourse = courseRepository.findById(id);
        optionalCourse.ifPresent((course)->{
            course.name = upToDateCourse.name;
            courseRepository.save(course);
        });
        return optionalCourse;
    }

    public void dropSpecificCourse(int id){
        courseRepository.deleteById(id);
    }
}
