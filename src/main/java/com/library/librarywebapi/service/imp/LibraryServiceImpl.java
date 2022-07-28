package com.library.librarywebapi.service.imp;

import com.library.librarywebapi.entity.Author;
import com.library.librarywebapi.entity.Library;
import com.library.librarywebapi.model.LibraryCreateModel;
import com.library.librarywebapi.model.LibraryModel;
import com.library.librarywebapi.model.mapper.LibraryMapper;
import com.library.librarywebapi.repository.LibraryRepository;
import com.library.librarywebapi.service.LibraryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    private final LibraryRepository libraryRepository;

    private final LibraryMapper libraryMapper;

    public LibraryServiceImpl(LibraryRepository libraryRepository, LibraryMapper libraryMapper){
        this.libraryRepository = libraryRepository;
        this.libraryMapper = libraryMapper;
    }

    @Override
    public Long create(LibraryCreateModel libraryCreateModel) {
        Library library = libraryMapper.toLibrary(libraryCreateModel);
        return this.libraryRepository.save(library).getId();
    }

    @Override
    public Page<Library> getAll(Pageable pageable) {
        return libraryRepository.findAll(pageable);
    }

    @Override
    public Library getByLocation(String location) {
        return libraryRepository.getByLocation(location).orElseThrow(() -> new EntityNotFoundException(location));
    }

    @Override
    public List<Library> searchByLocation(String address) {
        return libraryRepository.findByAddressLike(address);
    }

    @Override
    public List<Library> searchByName(String name) {
        return libraryRepository.findByNameLike(name);
    }


    @Override
    public void update(LibraryModel libraryModel) {
        Library library = libraryRepository.findById(libraryModel.getId()).orElseThrow(EntityNotFoundException::new);
        library = libraryMapper.map( libraryModel, library);
        libraryRepository.save(library);

    }

    @Override
    public void delete(Long id) {
        Library library = libraryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        libraryRepository.delete(library);

    }
}
