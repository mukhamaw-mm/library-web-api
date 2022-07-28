package com.library.librarywebapi.repository;

import com.library.librarywebapi.entity.Author;

import com.library.librarywebapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findByNameLike(String name);
}
