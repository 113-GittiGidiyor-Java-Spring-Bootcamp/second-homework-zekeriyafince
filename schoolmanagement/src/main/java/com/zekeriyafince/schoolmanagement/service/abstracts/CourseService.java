package com.zekeriyafince.schoolmanagement.service.abstracts;

import com.zekeriyafince.schoolmanagement.entity.concretes.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourses();

    Course getCourseById(Long id);

    Course createCourse(Course course);

    Course updateCourse(Long id, Course course);

    void deleteCourse(Long id);
}
