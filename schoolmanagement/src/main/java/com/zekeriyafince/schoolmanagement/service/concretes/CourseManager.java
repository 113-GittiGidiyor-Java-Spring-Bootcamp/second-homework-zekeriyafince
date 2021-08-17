package com.zekeriyafince.schoolmanagement.service.concretes;

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
}
