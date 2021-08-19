package com.zekeriyafince.schoolmanagement.dto;

import com.zekeriyafince.schoolmanagement.entity.abstracts.Instructor;
import com.zekeriyafince.schoolmanagement.entity.concretes.Student;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CourseUpdateDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private String courseCode;

    private int credit;

    private List<Student> students;

    private Instructor instructor;
}
