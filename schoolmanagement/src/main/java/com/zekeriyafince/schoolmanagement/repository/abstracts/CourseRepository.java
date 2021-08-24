package com.zekeriyafince.schoolmanagement.repository.abstracts;

import com.zekeriyafince.schoolmanagement.entity.concretes.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository<T> extends BaseRepository<Course> {
}
