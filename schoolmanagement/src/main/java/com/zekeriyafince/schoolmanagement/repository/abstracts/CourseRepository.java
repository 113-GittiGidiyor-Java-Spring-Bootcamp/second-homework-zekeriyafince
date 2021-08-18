package com.zekeriyafince.schoolmanagement.repository.abstracts;

import com.zekeriyafince.schoolmanagement.entity.concretes.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
}
