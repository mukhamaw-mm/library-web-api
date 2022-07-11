package com.library.librarywebapi.model.mapper;

import com.library.librarywebapi.entity.Category;
import com.library.librarywebapi.model.CategoryCreateModel;
import com.library.librarywebapi.model.CategoryModel;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category toCategory(CategoryCreateModel categoryCreateModelModel) {
        return Category.builder()
                .name(categoryCreateModelModel.getName())
                .build();
    }

    public Category map(CategoryModel categoryModel, Category entity) {
        entity.setName(categoryModel.getName());
        return entity;

    }

}
