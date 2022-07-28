package com.library.librarywebapi.repository;


import com.library.librarywebapi.entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>{

    @Query("select lb from Library lb where lb.location = :location order by lb.location asc ")
    Optional<Library> getByLocation(String location);

    List<Library> findByAddressLike(String address);

    @Query ("select lb from Library lb where lb.image = :image")
    Library getByImage(String image);

    List<Library> findByNameLike(String name);
}


