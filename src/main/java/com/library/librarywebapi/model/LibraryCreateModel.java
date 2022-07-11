package com.library.librarywebapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class LibraryCreateModel {
    @JsonIgnore
    private Long id;

    private String name;

    private String location;

    private String address;

    private String phone;

    private String image;

    private String type;

    private Boolean isDeleted;

}
