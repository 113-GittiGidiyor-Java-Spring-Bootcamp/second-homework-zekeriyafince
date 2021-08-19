package com.zekeriyafince.schoolmanagement.service.abstracts;

import com.zekeriyafince.schoolmanagement.dto.CourseCreateDto;
import com.zekeriyafince.schoolmanagement.dto.CourseViewDto;
import com.zekeriyafince.schoolmanagement.entity.concretes.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourses();

    Course getCourseById(Long id);

    CourseViewDto createCourse(CourseCreateDto courseCreateDto);

    Course updateCourse(Long id, Course course);

    void deleteCourse(Long id);
}
