package com.library.librarywebapi.service;

import com.library.librarywebapi.entity.Library;
import com.library.librarywebapi.model.LibraryCreateModel;
import com.library.librarywebapi.model.LibraryModel;

import java.util.List;

public interface LibraryService {
    Long create(LibraryCreateModel libraryCreateModel);

    List<Library> getAll();

    Library getByLocation(String location);


    void update(LibraryModel library);

    void delete(Long id);





}
