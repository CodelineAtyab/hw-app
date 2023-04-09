package com.dynamicdoers.hwapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pro_teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public int id;

    @Column
    public String name;
    @Column
    public String email;
    @Column
    public long hiredAt;

    @OneToOne(mappedBy = "mentor")
    public Course course;

}
