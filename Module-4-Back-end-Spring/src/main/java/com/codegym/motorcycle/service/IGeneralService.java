package com.codegym.motorcycle.controller;

import org.springframework.data.domain.Page;

import java.util.Optional;

public interface IGeneralService<T> {
    T save(T t);

    void remove(Long id);

    Page<T> findAll();

    Optional<T> findById(Long id);

}
