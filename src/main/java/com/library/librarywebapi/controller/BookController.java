package com.library.librarywebapi.controller;

import com.library.librarywebapi.entity.Book;
import com.library.librarywebapi.model.BookCreateModel;
import com.library.librarywebapi.model.BookModel;
import com.library.librarywebapi.service.BookService;
import com.library.librarywebapi.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    private final ImageService imageService;

    public BookController(BookService bookService, ImageService imageService) {
        this.bookService = bookService;
        this.imageService = imageService;

    }

    @PostMapping
    public ResponseEntity<Long> insert(@RequestPart("image") MultipartFile image,
                                       @Valid @RequestPart("book") BookCreateModel bookCreateModel) {
        UUID images = imageService.save(image);
        bookCreateModel.setImage(String.valueOf(images));

        Long id = bookService.insertBook(bookCreateModel);
        return ResponseEntity.created(URI.create("/api/books/" + id)).body(id);

    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        return ResponseEntity.ok(bookService.getAllBook());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> search(@RequestParam("title") String title) {
        return ResponseEntity.ok(bookService.searchByTitle(title + "%"));
    }

    @GetMapping("/library")
    public ResponseEntity<List<Book>> getByLibraryId(@RequestParam("libraryId") Optional<Long> libraryId) {
        List<Book> dataList;
        if(libraryId.isPresent())
            dataList = this.bookService.getByLibraryId(libraryId.get());
        else
            dataList = this.bookService.getAllBook();
        return new ResponseEntity<>(dataList, HttpStatus.OK);
    }


    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody BookModel model) {
        this.bookService.update(model);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.bookService.delete(id);
    }

}

