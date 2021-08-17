package com.zekeriyafince.schoolmanagement.api.controller;

import com.zekeriyafince.schoolmanagement.service.abstracts.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CoursesController {

    private final CourseService courseService;

    @Autowired
    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("courses")
    public ResponseEntity<?> getCourses() {
        return ResponseEntity.ok(this.courseService.getCourses());
    }
}
