package com.samrach.demo.testcase.service;

import com.samrach.demo.testcase.infrastructure.entity.CategoryEntity;
import com.samrach.demo.testcase.infrastructure.request.category.CategoryRequest;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    CategoryEntity create(CategoryRequest request);

    CategoryEntity update(Long id, CategoryRequest request);

    void delete(Long id);

    List<CategoryEntity> findAll();

    Optional<CategoryEntity> findById(Long id);
}
