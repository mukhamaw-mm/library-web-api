package com.library.librarywebapi.service.imp;

import com.library.librarywebapi.entity.Author;
import com.library.librarywebapi.entity.Category;
import com.library.librarywebapi.model.CategoryCreateModel;
import com.library.librarywebapi.model.CategoryModel;
import com.library.librarywebapi.model.mapper.CategoryMapper;
import com.library.librarywebapi.repository.CategoryRepository;
import com.library.librarywebapi.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper){
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }
    @Override
    public Long create(CategoryCreateModel categoryCreateModel) {
        Category category = categoryMapper.toCategory(categoryCreateModel);
        return this.categoryRepository.save(category).getId();
    }

    @Override
    public List<Category> getAll() {
            return categoryRepository.findAll();

    }

    @Override
    public void update(CategoryModel categoryModel) {
        Category category = categoryRepository.findById(categoryModel.getId()).orElseThrow(EntityNotFoundException::new);
        category = categoryMapper.map( categoryModel, category);
        categoryRepository.save(category);

    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        categoryRepository.delete(category);
    }
}
