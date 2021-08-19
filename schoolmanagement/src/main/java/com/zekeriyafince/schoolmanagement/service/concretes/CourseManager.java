package com.zekeriyafince.schoolmanagement.service.concretes;

import com.zekeriyafince.schoolmanagement.dto.CourseCreateDto;
import com.zekeriyafince.schoolmanagement.dto.CourseViewDto;
import com.zekeriyafince.schoolmanagement.entity.concretes.Course;
import com.zekeriyafince.schoolmanagement.repository.abstracts.CourseRepository;
import com.zekeriyafince.schoolmanagement.service.abstracts.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseManager implements CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseManager(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return this.courseRepository.findById(id).get();
    }

    @Override
    public CourseViewDto createCourse(CourseCreateDto courseCreateDto) {
        final Course course = this.courseRepository.save(new Course(courseCreateDto.getName(), courseCreateDto.getCourseCode(), courseCreateDto.getCredit(), courseCreateDto.getStudents(), courseCreateDto.getInstructor()));
        return CourseViewDto.of(course);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course oldCourse = this.courseRepository.getById(id);
        oldCourse.setCourseCode(course.getCourseCode());
        oldCourse.setCredit(course.getCredit());
        oldCourse.setInstructor(course.getInstructor());
        oldCourse.setStudents(course.getStudents());
        oldCourse.setName(course.getName());
        return this.courseRepository.save(oldCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        this.courseRepository.delete(this.courseRepository.getById(id));
    }
}
