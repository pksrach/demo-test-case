package com.samrach.demo.testcase.infrastructure.request.category;

import com.samrach.demo.testcase.infrastructure.entity.CategoryEntity;
import com.samrach.demo.testcase.persistence.request.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;


@EqualsAndHashCode(callSuper = true)
@Data
public class CategoryRequest extends BaseRequest<CategoryEntity> {
    private String name;
    private String description;

    public CategoryRequest(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public CategoryRequest() {
    }

    @Override
    public CategoryEntity toEntity() {
        return new CategoryEntity(name, description);
    }
}
