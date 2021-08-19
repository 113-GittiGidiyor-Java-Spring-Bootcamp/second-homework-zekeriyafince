package com.zekeriyafince.schoolmanagement.api.controller;

import com.zekeriyafince.schoolmanagement.dto.CourseCreateDto;
import com.zekeriyafince.schoolmanagement.dto.CourseUpdateDto;
import com.zekeriyafince.schoolmanagement.dto.CourseViewDto;
import com.zekeriyafince.schoolmanagement.entity.concretes.Course;
import com.zekeriyafince.schoolmanagement.service.abstracts.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class CoursesController {

    private final CourseService courseService;

    @Autowired
    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("course")
    public ResponseEntity<?> getCourses() {
        return ResponseEntity.ok(this.courseService.getCourses());
    }

    @GetMapping("course/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(this.courseService.getCourseById(id));
    }

    @PostMapping("course")
    public ResponseEntity<?> createCourse(@Valid @RequestBody CourseCreateDto courseCreateDto ) {
        CourseViewDto courseViewDto = this.courseService.createCourse(courseCreateDto);
        return ResponseEntity.ok(courseViewDto);
    }

    @PutMapping("course/{id}")
    public ResponseEntity<?> updateCourse(@Valid @PathVariable("id") Long id,
                                          @RequestBody CourseUpdateDto courseUpdateDto) {
        final CourseViewDto updateCourse = this.courseService.updateCourse(id, courseUpdateDto);
        return ResponseEntity.ok(updateCourse);
    }

    @DeleteMapping("course/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id) {
        this.courseService.deleteCourse(id);
        return ResponseEntity.ok("Course Deleted !");
    }

}
