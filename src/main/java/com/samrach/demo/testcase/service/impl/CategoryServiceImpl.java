package com.samrach.demo.testcase.service.impl;

import com.samrach.demo.testcase.infrastructure.entity.CategoryEntity;
import com.samrach.demo.testcase.infrastructure.request.category.CategoryRequest;
import com.samrach.demo.testcase.persistence.repository.BaseRepository;
import com.samrach.demo.testcase.persistence.service.BaseAbstractService;
import com.samrach.demo.testcase.service.CategoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl extends BaseAbstractService<CategoryRequest, CategoryEntity, Long> implements CategoryService {

    @Autowired
    public CategoryServiceImpl(BaseRepository<CategoryEntity, Long> repository) {
        super(repository);
    }

    @Transactional
    @Override
    public CategoryEntity create(CategoryRequest request) {
        return super.create(request);
    }

    @Transactional
    @Override
    public CategoryEntity update(Long id, CategoryRequest request) {
        CategoryEntity entity = super.findById(id).orElseThrow();

        // check request name must be not null
        if (request.getName() == null) {
            throw new RuntimeException("Category name is required");
        }

        // Check before set category name because it unique name
        if (!request.getName().equals(entity.getName())) {
            if (super.repository.existsByName(request.getName())) {
                throw new RuntimeException("Category name already exists");
            }
        }

        entity.setName(request.getName() != null ? request.getName() : entity.getName());
        entity.setDescription(request.getDescription() != null ? request.getDescription() : entity.getDescription());

        return super.repository.save(entity);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        super.delete(id);
    }

    @Override
    public Optional<CategoryEntity> findById(Long id) {
        return super.findById(id);
    }
}
