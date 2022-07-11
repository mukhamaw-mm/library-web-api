package com.library.librarywebapi.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LibraryModel {
    private Long id;

    private String name;

    private String location;

    private String address;

    private String phone;

    private String image;

    private String type;

    private Boolean isDeleted;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
