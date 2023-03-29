package com.dynamicdoers.hwapp.controller;

import com.dynamicdoers.hwapp.model.Student;
import com.dynamicdoers.hwapp.service.StudentService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/students")
public class StudentController {

    public StudentController(int id,
                             @Qualifier("getMyName") String name,
                             @Qualifier("getMyEmail") String email){
        System.out.println(">>>>>>>>>>> " + id + " - " + name + " -- " + email);
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping(path = "/{id}")
    public Optional<Student> getStudent(@PathVariable(name = "id") int id){
        return studentService.getStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student currStudent){
        studentService.createStudent(currStudent);
        return currStudent;
    }

    @PostMapping(path = "/withImage", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Student createStudentWithImage(@RequestParam String name,
                                          @RequestParam String email,
                                          @RequestParam(required = false) MultipartFile image) throws IOException {

        Student newStudent = new Student();
        newStudent.name = name;
        newStudent.email = email;
        Student savedStudent = studentService.createStudent(newStudent);

        if(image != null){
            savedStudent.imageName = Integer.toString(savedStudent.id) + "_" + savedStudent.name + ".jpg";
            FileUtils.writeByteArrayToFile(new File("./data/" + savedStudent.imageName), image.getBytes());
            studentService.updateStudent(savedStudent.id, savedStudent);
        }

        return savedStudent;
    }

    @PutMapping(path = "/{id}")
    public Student updateStudent(@PathVariable(name = "id") int id, @RequestBody Student currStudent){
        studentService.updateStudent(id, currStudent);
        return currStudent;
    }

    @DeleteMapping(path = "/{id}")
    public Student deleteStudent(@PathVariable(name = "id") int id){
        return studentService.deleteStudent(id);
    }

    @Autowired
    private StudentService studentService;
}
