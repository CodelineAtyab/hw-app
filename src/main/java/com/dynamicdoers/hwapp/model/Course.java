package com.dynamicdoers.hwapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public int id;

    @Column
    public String name;

    @OneToOne(optional = true, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "teacher_id", referencedColumnName = "id", unique = true)
    @JsonIgnore
    public Teacher mentor;

    @JsonProperty("teacher_id")
    public Integer getMentorId(){
        return mentor != null ? mentor.id : null;
    }

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    @JsonIgnore
    public Set<Student> enrolledStudents;
}
