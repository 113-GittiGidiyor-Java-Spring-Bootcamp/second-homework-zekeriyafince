package com.zekeriyafince.schoolmanagement.repository.concretes;

import com.zekeriyafince.schoolmanagement.entity.concretes.Course;
import com.zekeriyafince.schoolmanagement.repository.abstracts.CourseRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class CourseRepositoryHibernateImplement implements CourseRepository<Course> {

    private EntityManager entityManager;

    @Autowired
    public CourseRepositoryHibernateImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Course> findAll() {
        Session session = this.entityManager.unwrap(Session.class);
        return session.createQuery("from Course", Course.class).getResultList();
    }

    @Override
    public Course findById(Long id) {
        Session session = this.entityManager.unwrap(Session.class);
        return session.find(Course.class, id);
    }

    @Override
    public Course save(Course course) {
        Session session = this.entityManager.unwrap(Session.class);
        return (Course) session.merge(course);
    }

    @Override
    public void deleteById(Long id) {
        Session session = this.entityManager.unwrap(Session.class);
        session.remove(this.entityManager.find(Course.class, id));
    }

    @Override
    public Course update(Course course) {
        Session session = this.entityManager.unwrap(Session.class);
        return (Course) session.merge(course);
    }
}
