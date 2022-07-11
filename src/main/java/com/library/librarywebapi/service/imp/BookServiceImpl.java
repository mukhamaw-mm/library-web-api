package com.library.librarywebapi.service.imp;

import com.library.librarywebapi.entity.Book;
import com.library.librarywebapi.model.BookCreateModel;
import com.library.librarywebapi.model.BookModel;
import com.library.librarywebapi.model.mapper.BookMapper;
import com.library.librarywebapi.repository.BookRepository;
import com.library.librarywebapi.service.BookService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper){
    this.bookRepository = bookRepository;
    this.bookMapper = bookMapper;
    }

    @Override
    public Long insertBook(BookCreateModel bookCreateModel) {
        Book book = bookMapper.toBook(bookCreateModel);
        return this.bookRepository.save(book).getId();

    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return bookRepository.findByTitleLike(title);
    }

    @Override
    public List<Book> getByLibraryId(Long libraryId) {
        return bookRepository.findByLibraryId(libraryId);
    }

    @Override
    public void update(BookModel bookModel) {
        Book book = bookRepository.findById(bookModel.getId()).orElseThrow(EntityNotFoundException::new);
        book = bookMapper.map( bookModel, book);
        bookRepository.save(book);

    }

    @Override
    public void delete(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        bookRepository.delete(book);
    }
}
