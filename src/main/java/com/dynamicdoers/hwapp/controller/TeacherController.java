package com.dynamicdoers.hwapp.controller;

import com.dynamicdoers.hwapp.model.Teacher;
import com.dynamicdoers.hwapp.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @GetMapping
    public List<Teacher> getAllTeachers(){
        return teacherService.getAllTeachersInfo();
    }

    @GetMapping(path = "/{id}")
    public Optional<Teacher> getSpecificTeacher(@PathVariable int id){
        return teacherService.getSpecificTeacherInfo(id);
    }

    @PostMapping
    public Teacher hireTeacher(@RequestBody Teacher teacher){
        return teacherService.hireTeacher(teacher);
    }

    @PutMapping(path = "/{id}")
    public Optional<Teacher> updateSpecificTeacher(@PathVariable int id, @RequestBody Teacher teacher){
        return teacherService.updateSpecificTeacherInfo(id, teacher);
    }

    @DeleteMapping(path = "/{id}")
    public Optional<Teacher> fireTeacher(@PathVariable int id){
        return teacherService.fireTeacher(id);
    }
}
