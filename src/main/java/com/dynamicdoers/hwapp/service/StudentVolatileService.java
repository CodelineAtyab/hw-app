package com.dynamicdoers.hwapp.service;

import com.dynamicdoers.hwapp.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class StudentVolatileService {

    public List<Student> getAllStudents(){
        logger.error("Getting all the students");
        return listOfStudent;
    }

    public Student getStudent(int id) {
        Optional<Student> foundRecord = listOfStudent.stream().filter(
                (currentStudent) -> {
                    return currentStudent.id == id;
                }
        ).findFirst();

        return foundRecord.orElse(null);
    }

    public Student createStudent(Student currStudent){
        currStudent.id = this.currId++;
        listOfStudent.add(currStudent);
        logger.info("Created student with id: " + currStudent.id);

        return currStudent;
    }

    public Student updateStudent(int id, Student upToDateStudent){
        Student foundStudent = getStudent(id);
        foundStudent.name = upToDateStudent.name;
        foundStudent.email = upToDateStudent.email;

        return foundStudent;
    }

    public Student deleteStudent(int id){
        Student foundStudent = getStudent(id);
        listOfStudent.remove(foundStudent);
        return foundStudent;
    }

    public List<Student> listOfStudent = new CopyOnWriteArrayList<>();
    private static final Logger logger = LoggerFactory.getLogger(StudentVolatileService.class);
    private int currId = 1;

}
