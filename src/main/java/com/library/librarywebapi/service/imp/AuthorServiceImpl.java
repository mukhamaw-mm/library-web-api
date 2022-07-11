package com.library.librarywebapi.service.imp;

import com.library.librarywebapi.entity.Author;
import com.library.librarywebapi.model.AuthorCreateModel;
import com.library.librarywebapi.model.AuthorModel;
import com.library.librarywebapi.model.mapper.AuthorMapper;
import com.library.librarywebapi.repository.AuthorRepository;
import com.library.librarywebapi.service.AuthorService;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper){
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;

    }
    @Override
    public Long create(AuthorCreateModel authorCreateModel) {
        Author author = authorMapper.toAuthor(authorCreateModel);
        return this.authorRepository.save(author).getId();
    }

    @Override
    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    @Override
    public void update(AuthorModel authorModel) {
    Author author = authorRepository.findById(authorModel.getId()).orElseThrow(EntityNotFoundException::new);
     author = authorMapper.map( authorModel, author);
     authorRepository.save(author);

    }

    @Override
    public void delete(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        authorRepository.delete(author);


    }
}
