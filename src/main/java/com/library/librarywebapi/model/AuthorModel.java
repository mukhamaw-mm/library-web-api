package com.library.librarywebapi.model;




import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class AuthorModel {

    private Long id;

    private String name;

    private Boolean isDeleted;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;
}
