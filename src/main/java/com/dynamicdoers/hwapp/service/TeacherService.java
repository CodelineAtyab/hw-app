package com.dynamicdoers.hwapp.service;

import com.dynamicdoers.hwapp.model.Teacher;
import com.dynamicdoers.hwapp.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public Optional<Teacher> getSpecificTeacherInfo(int id){
        return teacherRepository.findById(id);
    }

    public List<Teacher> getAllTeachersInfo(){
        return teacherRepository.findAll();
    }

    public Teacher hireTeacher(Teacher teacher){
        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> updateSpecificTeacherInfo(int id, Teacher upToDateTeacher){
        Optional<Teacher> foundTeacher = getSpecificTeacherInfo(id);
        foundTeacher.ifPresent(
                (currTeacher)->{
                    currTeacher.name = upToDateTeacher.name;
                    currTeacher.email = upToDateTeacher.email;
                    currTeacher.hiredAt = upToDateTeacher.hiredAt;

                    teacherRepository.save(currTeacher);
                }
        );
        return foundTeacher;
    }

    public Optional<Teacher> fireTeacher(int id){
        Optional<Teacher> teacher = getSpecificTeacherInfo(id);
        teacherRepository.deleteById(id);
        return teacher;
    }

}
