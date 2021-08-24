package com.zekeriyafince.schoolmanagement.repository.abstracts;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseRepository<T> {
    List<T> findAll();
    T findById(Long id);
    T save(T object);
    void deleteById(Long id);
    T update(T object);
}
