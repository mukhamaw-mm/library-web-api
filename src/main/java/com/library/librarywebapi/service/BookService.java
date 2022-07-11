package com.library.librarywebapi.service;

import com.library.librarywebapi.entity.Book;
import com.library.librarywebapi.model.BookCreateModel;
import com.library.librarywebapi.model.BookModel;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Long insertBook(BookCreateModel bookCreateModel);
    List<Book> getAllBook();
    List<Book> searchByTitle(String title);

    List<Book> getByLibraryId(Long LibraryId);

    void update(BookModel bookModel);
    void delete(Long id);





}

