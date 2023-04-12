package com.dynamicdoers.hwapp.controller;

import com.dynamicdoers.hwapp.model.Course;
import com.dynamicdoers.hwapp.model.CourseEnrollment;
import com.dynamicdoers.hwapp.model.Student;
import com.dynamicdoers.hwapp.service.CourseService;
import com.dynamicdoers.hwapp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/courseEnrollment")
public class CourseEnrollmentController {
    @Autowired
    CourseService courseService;
    @Autowired
    StudentService studentService;

    @PostMapping
    public void enrollStudentsInCourse(@RequestBody CourseEnrollment currEnrollment){
        Optional<Course> optionalCourse = courseService.getSpecificCourse(currEnrollment.courseId);
        optionalCourse.ifPresentOrElse((course -> {
            currEnrollment.studentIds.forEach((currStudentId) -> {
                Optional<Student> optionalStudent = studentService.getStudent(currStudentId);
                optionalStudent.ifPresent((student -> {
                    course.enrolledStudents.add(student);
                }));
            });
            courseService.updateCourse(course.id, course);
        }), ()->{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Course Not Found");
        });
    }
}
