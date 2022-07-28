package com.library.librarywebapi.controller;

import com.library.librarywebapi.entity.Author;
import com.library.librarywebapi.entity.Book;
import com.library.librarywebapi.model.AuthorCreateModel;
import com.library.librarywebapi.model.AuthorModel;
import com.library.librarywebapi.service.AuthorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService){
        this.authorService = authorService;
    }

    @PostMapping
    public ResponseEntity<Long> create(AuthorCreateModel author){
        Long id = authorService.create(author);
        return ResponseEntity.created(URI.create("/api/author/" + id)).body(id);
    }

    @GetMapping
    public ResponseEntity<Page<Author>> getAll(int page,int size){
        return ResponseEntity.ok(authorService.getAll(PageRequest.of(page, size)));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Author>> search(@RequestParam("name") String name) {
        return ResponseEntity.ok(authorService.searchByName(name + "%"));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody AuthorModel model) {
        this.authorService.update(model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.authorService.delete(id);
    }

}
