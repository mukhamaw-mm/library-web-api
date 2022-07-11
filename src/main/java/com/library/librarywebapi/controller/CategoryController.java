package com.library.librarywebapi.controller;

import com.library.librarywebapi.entity.Category;
import com.library.librarywebapi.model.CategoryCreateModel;
import com.library.librarywebapi.model.CategoryModel;
import com.library.librarywebapi.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Long> create(CategoryCreateModel categoryCreateModel){
        Long id = categoryService.create(categoryCreateModel);
        return ResponseEntity.created(URI.create("/api/author/" + id)).body(id);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok(categoryService.getAll());
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody CategoryModel model) {
        this.categoryService.update(model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.categoryService.delete(id);
    }

}
