package com.library.librarywebapi.model.mapper;

import com.library.librarywebapi.entity.Author;
import com.library.librarywebapi.model.AuthorCreateModel;
import com.library.librarywebapi.model.AuthorModel;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author toAuthor(AuthorCreateModel authorCreateModel) {
        return Author.builder()
                .name(authorCreateModel.getName())
                .build();
    }

    public Author map(AuthorModel authorModel, Author entity) {
        entity.setName(authorModel.getName());
        return entity;

    }
}
