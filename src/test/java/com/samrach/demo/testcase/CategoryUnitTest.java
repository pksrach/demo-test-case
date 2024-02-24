package com.samrach.demo.testcase;

import com.samrach.demo.testcase.controller.CategoryController;
import com.samrach.demo.testcase.infrastructure.entity.CategoryEntity;
import com.samrach.demo.testcase.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CategoryUnitTest {
    private final CategoryService mockService;

    public CategoryUnitTest() {
        // Mock service
        mockService = Mockito.mock(CategoryService.class);
    }

    // Mocking the data
    private List<CategoryEntity> categories() {
        List<CategoryEntity> categoryEntityList = new ArrayList<>();
        categoryEntityList.add(new CategoryEntity(1L, "Food", "Details about Food"));
        categoryEntityList.add(new CategoryEntity(2L, "Drink", "Details about Drink"));

        return categoryEntityList;
    }

    // Method get all categories
    @Test
    public void getAllCategories() {
        // Arrange
        var list = categories();
        Mockito.when(mockService.findAll()).thenReturn(list);
        var controller = new CategoryController(mockService);

        // Action
        var result = controller.gets();
        var okResult = result.getBody();

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertInstanceOf(List.class, okResult, "okResult is not an instance of List<CategoryEntity>");

        Assertions.assertEquals(list.size(), ((List<CategoryEntity>) okResult).size(), "Size of list is not equal to size of okResult");

        Assertions.assertEquals(200, result.getStatusCode().value());

        Assertions.assertEquals(list.get(0).getName(), ((List<CategoryEntity>) okResult).get(0).getName(), "Name of list is not equal to name of okResult");
    }

    // Method get category by id
    @Test
    public void getCategoryById() {
        // Arrange
        Long id = 1L;
        var categoryEntity = categories().stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
        Mockito.when(mockService.findById(id)).thenReturn(Optional.ofNullable(categoryEntity));
        var controller = new CategoryController(mockService);

        // Action
        var result = controller.get(id);
        var okResult = result.getBody();

        // Assert
        Assertions.assertNotNull(result);

        Assertions.assertEquals(200, result.getStatusCode().value());

        Assertions.assertInstanceOf(Optional.class, okResult, "okResult is not an instance of CategoryEntity");

        var category = (Optional<CategoryEntity>) okResult;
        assert categoryEntity != null;
        Assertions.assertEquals(categoryEntity.getName(), category.get().getName(), "Name of list is not equal to name of okResult");
    }
}
