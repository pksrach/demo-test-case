package com.samrach.demo.testcase.controller;

import com.samrach.demo.testcase.constant.RestApi;
import com.samrach.demo.testcase.infrastructure.entity.CategoryEntity;
import com.samrach.demo.testcase.infrastructure.request.category.CategoryRequest;
import com.samrach.demo.testcase.infrastructure.response.response.CategoryResponse;
import com.samrach.demo.testcase.persistence.response.ResponseBody;
import com.samrach.demo.testcase.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RestApi.Backend.CATEGORY)
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseBody<CategoryResponse> create(
            @RequestBody CategoryRequest request
    ) {
        CategoryEntity data = categoryService.create(request);

        return new ResponseBody<>(
                CategoryResponse.fromEntity(data),
                "Category created successfully"
        );
    }

    @GetMapping
    public ResponseBody<List<CategoryResponse>> gets() {
        List<CategoryEntity> data = categoryService.findAll();

        List<CategoryResponse> responses = data.stream()
                .map(CategoryResponse::fromEntity)
                .toList();

        return new ResponseBody<>(
                responses,
                "Categories fetched successfully"
        );
    }
}
