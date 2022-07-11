package com.library.librarywebapi.service;

import com.library.librarywebapi.entity.Author;
import com.library.librarywebapi.model.AuthorCreateModel;
import com.library.librarywebapi.model.AuthorModel;

import java.util.List;

public interface AuthorService {
    Long create(AuthorCreateModel authorCreateModel);

    List<Author> getAll();

    void update(AuthorModel authorModel);

    void delete(Long id);

}
