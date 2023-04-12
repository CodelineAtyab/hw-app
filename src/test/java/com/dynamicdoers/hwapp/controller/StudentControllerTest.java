package com.dynamicdoers.hwapp.controller;

import com.dynamicdoers.hwapp.model.Student;
import com.dynamicdoers.hwapp.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Base64;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    public void getStudent() throws Exception {
        int testStudentId = 1;
        Student testStudent = new Student();
        testStudent.id = testStudentId;
        testStudent.name = "John Doe";
        testStudent.email = "some@some.com";

        String basicAuthHeader = "Basic " + Base64.getEncoder().encodeToString(("mra" + ":" + "mrapass").getBytes());

        when(studentService.getStudent(testStudentId)).thenReturn(Optional.of(testStudent));

        // Perform the GET request and check the result
        mockMvc.perform(get("/api/students/{id}", testStudentId)
                        .header("Authorization", basicAuthHeader)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.name").exists());

        // Verify the service method was called once
        verify(studentService, times(1)).getStudent(testStudentId);
    }
}