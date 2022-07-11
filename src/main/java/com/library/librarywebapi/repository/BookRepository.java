package com.library.librarywebapi.repository;

import com.library.librarywebapi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("select b from Book b where b.libraryId = :libraryId order by b.updatedDate")
    List<Book> findByLibraryId(Long libraryId);
    List<Book> findByTitleLike(String title);




}
