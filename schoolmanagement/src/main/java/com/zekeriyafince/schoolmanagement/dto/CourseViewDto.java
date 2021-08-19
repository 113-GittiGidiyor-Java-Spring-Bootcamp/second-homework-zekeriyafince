package com.zekeriyafince.schoolmanagement.dto;

import com.zekeriyafince.schoolmanagement.entity.abstracts.Instructor;
import com.zekeriyafince.schoolmanagement.entity.concretes.Course;
import com.zekeriyafince.schoolmanagement.entity.concretes.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
@AllArgsConstructor
public final class CourseViewDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private String courseCode;

    private int credit;

    private List<Student> students;

    private Instructor instructor;

    public static CourseViewDto of(Course course) {
        return new CourseViewDto(course.getName(),course.getCourseCode(),course.getCredit(),course.getStudents(),course.getInstructor());
    }
}
