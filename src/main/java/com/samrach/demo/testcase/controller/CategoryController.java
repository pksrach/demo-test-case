package com.samrach.demo.testcase.controller;

import com.samrach.demo.testcase.constant.RestApi;
import com.samrach.demo.testcase.infrastructure.entity.CategoryEntity;
import com.samrach.demo.testcase.infrastructure.request.category.CategoryRequest;
import com.samrach.demo.testcase.infrastructure.response.response.CategoryResponse;
import com.samrach.demo.testcase.persistence.response.ResponseBody;
import com.samrach.demo.testcase.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(RestApi.Backend.CATEGORY)
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Object> gets() {
        List<CategoryEntity> data = categoryService.findAll();

        return ResponseEntity.ok(data);
    }

    /*@GetMapping
    public ResponseBody<List<CategoryResponse>> gets() {
        List<CategoryEntity> data = categoryService.findAll();

        List<CategoryResponse> responses = data.stream()
                .map(CategoryResponse::fromEntity)
                .toList();

        return new ResponseBody<>(
                responses,
                "Categories fetched successfully"
        );
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Object> get(
            @PathVariable Long id
    ) {
        Optional<CategoryEntity> data = categoryService.findById(id);
        return ResponseEntity.ok(data);

    }

    @PostMapping
    public ResponseEntity<Object> create(
            @RequestBody CategoryRequest request
    ) {
        CategoryEntity data = categoryService.create(request);

        return ResponseEntity.ok(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable Long id,
            @RequestBody CategoryRequest request
    ) {
        CategoryEntity data = categoryService.update(id, request);

        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/{id}")
    public ResponseBody<CategoryResponse> delete(
            @PathVariable Long id
    ) {
        categoryService.delete(id);

        return new ResponseBody<>(
                null,
                "Category deleted successfully"
        );
    }
}
