package com.library.librarywebapi.repository;

import com.library.librarywebapi.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>{
    @Query("select lb from Library lb where lb.location = :location")
    Optional<Library> getByLocation(String location);

    @Query ("select lb from Library lb where lb.image = :image")
    Library getByImage(String image);
}


