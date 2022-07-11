package com.library.librarywebapi.model.mapper;

import com.library.librarywebapi.entity.Library;
import com.library.librarywebapi.model.LibraryCreateModel;
import com.library.librarywebapi.model.LibraryModel;
import org.springframework.stereotype.Component;

@Component
public class LibraryMapper {
    public Library toLibrary(LibraryCreateModel libraryCreateModel) {
        return Library.builder()
                .name(libraryCreateModel.getName())
                .location(libraryCreateModel.getLocation())
                .address(libraryCreateModel.getAddress())
                .phone(libraryCreateModel.getPhone())
                .image(libraryCreateModel.getImage())
                .type(libraryCreateModel.getType())
                .isDeleted(libraryCreateModel.getIsDeleted())
                .build();
    }

    public Library map(LibraryModel libraryModel, Library entity) {
        entity.setName(libraryModel.getName());
        entity.setLocation(libraryModel.getLocation());
        entity.setAddress(libraryModel.getAddress());
        entity.setPhone(libraryModel.getPhone());
        entity.setImage(libraryModel.getImage());
        entity.setType(libraryModel.getType());
        entity.setIsDeleted(libraryModel.getIsDeleted());
        return entity;

    }
}
