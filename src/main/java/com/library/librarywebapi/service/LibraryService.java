package com.library.librarywebapi.service;

import com.library.librarywebapi.entity.Author;
import com.library.librarywebapi.entity.Library;
import com.library.librarywebapi.model.LibraryCreateModel;
import com.library.librarywebapi.model.LibraryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LibraryService {
    Long create(LibraryCreateModel libraryCreateModel);

    Page<Library> getAll(Pageable pageable);

    Library getByLocation(String location);


    List<Library> searchByLocation(String address);

    List<Library> searchByName(String name);


    void update(LibraryModel library);

    void delete(Long id);





}
