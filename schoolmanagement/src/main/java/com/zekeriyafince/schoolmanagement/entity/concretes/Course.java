package com.zekeriyafince.schoolmanagement.entity.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zekeriyafince.schoolmanagement.entity.abstracts.Instructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "students"})
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "course_code")
    private String courseCode;
    @Column(name = "credit")
    private int credit;

    @ManyToMany
    private List<Student> students;

    @ManyToOne
    private Instructor instructor;


}
