package com.samrach.demo.testcase.service;

import com.samrach.demo.testcase.infrastructure.entity.CategoryEntity;
import com.samrach.demo.testcase.infrastructure.request.category.CategoryRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    CategoryEntity create(CategoryRequest request);

    CategoryEntity update(Long id, CategoryRequest request);

    void delete(Long id);

    List<CategoryEntity> findAll();

    Page<CategoryEntity> findAll(Pageable pageable);

    Optional<CategoryEntity> findById(Long id);
}
