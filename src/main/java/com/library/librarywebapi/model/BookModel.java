package com.library.librarywebapi.model;



import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
public class BookModel {
    private Long id;

    private String title;

    private String publishingHouse;

    private LocalDate publishedYear;

    private String description;

    private String page;

    private String type;

    private String image;

    private String orgPrice;

    private String chargesFee;

    private Long libraryId;

    private Long authorId;

    private Long categoryId;

    private Boolean isDeleted;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
