package com.library.librarywebapi.service;

import com.library.librarywebapi.entity.Author;
import com.library.librarywebapi.entity.Category;
import com.library.librarywebapi.model.AuthorCreateModel;
import com.library.librarywebapi.model.AuthorModel;
import com.library.librarywebapi.model.CategoryCreateModel;
import com.library.librarywebapi.model.CategoryModel;

import java.util.List;

public interface CategoryService {
    Long create(CategoryCreateModel categoryCreateModel);

    List<Category> getAll();

    void update(CategoryModel categoryModel);

    void delete(Long id);
}
