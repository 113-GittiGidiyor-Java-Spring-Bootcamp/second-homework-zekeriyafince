package com.zekeriyafince.schoolmanagement.repository.concretes;

import com.zekeriyafince.schoolmanagement.entity.concretes.Course;
import com.zekeriyafince.schoolmanagement.repository.abstracts.CourseRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseRepositoryJpaImplement implements CourseRepository<Course> {

    private EntityManager entityManager;


    @Override
    public List<Course> findAll() {
        return this.entityManager.createQuery("FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course findById(Long id) {
        return this.entityManager.find(Course.class,id);
    }

    @Override
    public Course save(Course course) {
        return this.entityManager.merge(course);
    }

    @Override
    public void deleteById(Long id) {
        this.entityManager.remove(this.entityManager.find(Course.class, id));
    }

    @Override
    public Course update(Course course) {
        return this.entityManager.merge(course);
    }
}
