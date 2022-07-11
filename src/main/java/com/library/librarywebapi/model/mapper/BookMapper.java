package com.library.librarywebapi.model.mapper;

import com.library.librarywebapi.entity.Book;
import com.library.librarywebapi.model.BookCreateModel;
import com.library.librarywebapi.model.BookModel;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public Book toBook(BookCreateModel bookCreateModel) {
        return Book.builder()
                .title(bookCreateModel.getTitle())
                .publishingHouse(bookCreateModel.getPublishingHouse())
                .publishedYear(bookCreateModel.getPublishedYear())
                .description(bookCreateModel.getDescription())
                .page(bookCreateModel.getPage())
                .type(bookCreateModel.getType())
                .image(bookCreateModel.getImage())
                .orgPrice(bookCreateModel.getOrgPrice())
                .chargesFee(bookCreateModel.getChargesFee())
                .libraryId(bookCreateModel.getLibraryId())
                .authorId(bookCreateModel.getAuthorId())
                .categoryId(bookCreateModel.getCategoryId())
                .isDeleted(bookCreateModel.getIsDeleted())
                .build();
    }

    public Book map(BookModel bookModel, Book entity) {
        entity.setTitle(bookModel.getTitle());
        entity.setPublishingHouse(bookModel.getPublishingHouse());
        entity.setPublishedYear(bookModel.getPublishedYear());
        entity.setDescription(bookModel.getDescription());
        entity.setPage(bookModel.getPage());
        entity.setType(bookModel.getType());
        entity.setImage(bookModel.getImage());
        entity.setOrgPrice(bookModel.getOrgPrice());
        entity.setChargesFee(bookModel.getChargesFee());
        entity.setLibraryId(bookModel.getLibraryId());
        entity.setAuthorId(bookModel.getAuthorId());
        entity.setCategoryId(bookModel.getCategoryId());
        entity.setIsDeleted(bookModel.getIsDeleted());
        return entity;

    }
}
