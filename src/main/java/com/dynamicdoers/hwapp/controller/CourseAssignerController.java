package com.dynamicdoers.hwapp.controller;

import com.dynamicdoers.hwapp.model.Course;
import com.dynamicdoers.hwapp.model.CourseAssigner;
import com.dynamicdoers.hwapp.model.Teacher;
import com.dynamicdoers.hwapp.service.CourseService;
import com.dynamicdoers.hwapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/assigner")
public class CourseAssignerController {
    @Autowired
    CourseService courseService;
    @Autowired
    TeacherService teacherService;

    @PostMapping
    public CourseAssigner assignMentorToCourse(@RequestBody CourseAssigner assigner){
        Optional<Course> optionalCourse = courseService.getSpecificCourse(assigner.course_id);
        Optional<Teacher> optionalTeacher = teacherService.getSpecificTeacherInfo(assigner.teacher_id);

        optionalCourse.ifPresent((course)->{
            optionalTeacher.ifPresent((teacher)->{
                course.mentor = teacher;
                courseService.registerCourse(course);
            });
        });

        return assigner;
    }
}
