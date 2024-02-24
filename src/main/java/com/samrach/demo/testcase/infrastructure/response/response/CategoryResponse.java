package com.samrach.demo.testcase.infrastructure.response.response;

import com.samrach.demo.testcase.infrastructure.entity.CategoryEntity;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CategoryResponse {
    private Long id;
    private String name;
    private String description;

    public static CategoryResponse fromEntity(CategoryEntity entity) {
        CategoryResponse response = new CategoryResponse();
        response.setId(entity.getId());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        return response;
    }

    public static List<CategoryResponse> fromEntities(List<CategoryEntity> entities) {
        return entities.stream()
                .map(CategoryResponse::fromEntity)
                .collect(Collectors.toList());
    }
}
