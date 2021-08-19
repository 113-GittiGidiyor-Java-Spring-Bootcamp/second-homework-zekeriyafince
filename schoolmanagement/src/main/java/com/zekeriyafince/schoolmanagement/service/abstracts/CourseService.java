package com.zekeriyafince.schoolmanagement.service.abstracts;

import com.zekeriyafince.schoolmanagement.dto.CourseCreateDto;
import com.zekeriyafince.schoolmanagement.dto.CourseUpdateDto;
import com.zekeriyafince.schoolmanagement.dto.CourseViewDto;
import com.zekeriyafince.schoolmanagement.entity.concretes.Course;

import java.util.List;

public interface CourseService {

    List<CourseViewDto> getCourses();

    CourseViewDto getCourseById(Long id);

    CourseViewDto createCourse(CourseCreateDto courseCreateDto);

    CourseViewDto updateCourse(Long id, CourseUpdateDto courseUpdateDto);

    void deleteCourse(Long id);
}
