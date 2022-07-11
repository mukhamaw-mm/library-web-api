package com.library.librarywebapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class BookCreateModel {
    @JsonIgnore
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


}
