package com.library.librarywebapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthorCreateModel {
    @JsonIgnore
    private Long id;

    private String name;

    private Boolean isDeleted;
}
