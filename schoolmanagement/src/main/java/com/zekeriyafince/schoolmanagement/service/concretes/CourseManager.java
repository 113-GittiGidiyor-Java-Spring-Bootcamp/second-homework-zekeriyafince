package com.zekeriyafince.schoolmanagement.service.concretes;

import com.zekeriyafince.schoolmanagement.dto.CourseCreateDto;
import com.zekeriyafince.schoolmanagement.dto.CourseUpdateDto;
import com.zekeriyafince.schoolmanagement.dto.CourseViewDto;
import com.zekeriyafince.schoolmanagement.entity.concretes.Course;
import com.zekeriyafince.schoolmanagement.repository.abstracts.CourseRepository;
import com.zekeriyafince.schoolmanagement.service.abstracts.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseManager implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseManager(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<CourseViewDto> getCourses() {
        return this.courseRepository.findAll().stream().map(CourseViewDto::of).collect(Collectors.toList());
    }

    @Override
    public CourseViewDto getCourseById(Long id) {
        Course course = this.courseRepository.findById(id).get();
        return CourseViewDto.of(course);
    }

    @Override
    public CourseViewDto createCourse(CourseCreateDto courseCreateDto) {
        final Course course = this.courseRepository.save(new Course(courseCreateDto.getName(), courseCreateDto.getCourseCode(), courseCreateDto.getCredit(), courseCreateDto.getStudents(), courseCreateDto.getInstructor()));
        return CourseViewDto.of(course);
    }

    @Override
    @Transactional
    public CourseViewDto updateCourse(Long id, CourseUpdateDto courseUpdateDto) {
        Course oldCourse = this.courseRepository.getById(id);
        oldCourse.setCourseCode(courseUpdateDto.getCourseCode());
        oldCourse.setCredit(courseUpdateDto.getCredit());
        oldCourse.setInstructor(courseUpdateDto.getInstructor());
        oldCourse.setStudents(courseUpdateDto.getStudents());
        oldCourse.setName(courseUpdateDto.getName());
        Course newCourse = this.courseRepository.save(oldCourse);
        return CourseViewDto.of(newCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        this.courseRepository.delete(this.courseRepository.getById(id));
    }
}
