package com.samrach.demo.testcase.controller;

import com.samrach.demo.testcase.constant.RestApi;
import com.samrach.demo.testcase.infrastructure.entity.CategoryEntity;
import com.samrach.demo.testcase.infrastructure.request.category.CategoryRequest;
import com.samrach.demo.testcase.infrastructure.response.response.CategoryResponse;
import com.samrach.demo.testcase.persistence.response.ResponseBody;
import com.samrach.demo.testcase.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(RestApi.Backend.CATEGORY)
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseBody<CategoryResponse> gets(
            Pageable pageable
    ) {
        Page<CategoryEntity> data = categoryService.findAll(pageable);
        Page<CategoryResponse> responses = CategoryResponse.fromEntities(data);


        return ResponseBody.success(
                responses,
                "Categories fetched successfully"
        );
    }

    /*@GetMapping
    public ResponseBody<List<CategoryResponse>> gets() {
        List<CategoryEntity> data = categoryService.findAll();

        List<CategoryResponse> responses = data.stream()
                .map(CategoryResponse::fromEntity)
                .toList();

        return ResponseBody.success(
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

        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable Long id,
            @RequestBody CategoryRequest request
    ) {
        CategoryEntity data = categoryService.update(id, request);

        return ResponseEntity.status(HttpStatus.OK).body(data);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(
            @PathVariable Long id
    ) {
        if (id == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error");
        }

        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Delete Success");
    }
}
