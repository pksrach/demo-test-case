package com.samrach.demo.testcase.service.impl;

import com.samrach.demo.testcase.infrastructure.entity.CategoryEntity;
import com.samrach.demo.testcase.infrastructure.request.category.CategoryRequest;
import com.samrach.demo.testcase.persistence.repository.BaseRepository;
import com.samrach.demo.testcase.persistence.service.BaseAbstractService;
import com.samrach.demo.testcase.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl extends BaseAbstractService<CategoryRequest, CategoryEntity, Long> implements CategoryService {

    @Autowired
    public CategoryServiceImpl(BaseRepository<CategoryEntity, Long> repository) {
        super(repository);
    }

    @Override
    public CategoryEntity create(CategoryRequest request) {
        return super.create(request);
    }

    @Override
    public CategoryEntity update(Long id, CategoryRequest request) {
        return super.update(id, request);
    }

    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public Optional<CategoryEntity> findById(Long id) {
        return super.findById(id);
    }
}
