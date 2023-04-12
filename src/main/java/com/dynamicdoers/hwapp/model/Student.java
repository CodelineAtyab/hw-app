package com.dynamicdoers.hwapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.Set;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column
    public String name;
    @Column
    @Pattern(regexp = "^[a-z|A-Z|.]+@[a-z|A-Z]+\\.[a-z|A-Z]{2,}$")
    public String email;

    @Column
    public String imageName;

    @ManyToMany(mappedBy = "enrolledStudents")
    @JsonIgnore
    public Set<Course> registeredCourses;
}
