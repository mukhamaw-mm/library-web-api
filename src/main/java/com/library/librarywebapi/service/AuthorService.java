package com.library.librarywebapi.service;

import com.library.librarywebapi.entity.Author;
import com.library.librarywebapi.entity.Book;
import com.library.librarywebapi.entity.Library;
import com.library.librarywebapi.model.AuthorCreateModel;
import com.library.librarywebapi.model.AuthorModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface AuthorService {
    Long create(AuthorCreateModel authorCreateModel);

    Page<Author> getAll(Pageable pageable);

    List<Author> searchByName(String name);

    void update(AuthorModel authorModel);

    void delete(Long id);

}
