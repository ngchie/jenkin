package com.wng.jenkin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository <T, ID extends Serializable> extends JpaRepository<T, ID> {
    T getReference( ID id);
    void detach(T obj);
}