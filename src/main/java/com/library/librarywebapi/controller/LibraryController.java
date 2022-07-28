package com.library.librarywebapi.controller;

import com.library.librarywebapi.entity.Author;
import com.library.librarywebapi.entity.Library;
import com.library.librarywebapi.model.LibraryCreateModel;
import com.library.librarywebapi.model.LibraryModel;
import com.library.librarywebapi.service.ImageService;
import com.library.librarywebapi.service.LibraryService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/library")
public class LibraryController {
    private final LibraryService libraryService;

    private final ImageService imageService;

    public LibraryController(LibraryService libraryService, ImageService imageService){
        this.libraryService = libraryService;
        this.imageService = imageService;
    }

    @PostMapping
    public ResponseEntity<Long> create(@RequestPart("image") MultipartFile image,
                                       @Valid @RequestPart("library")LibraryCreateModel model){

        UUID images = imageService.save(image);
        model.setImage(String.valueOf(images));

        Long id = libraryService.create(model);
        return ResponseEntity.created(URI.create("/api/library/" + id)).body(id);
    }

    @GetMapping
    public ResponseEntity<Page<Library>> getAll(int page, int size){
        return ResponseEntity.ok(libraryService.getAll(PageRequest.of(page, size)));
    }

    @GetMapping("/location")
    public ResponseEntity<Library> getByLocation(@RequestParam String location) {
        return ResponseEntity.ok(libraryService.getByLocation(location));
    }

    @GetMapping("/address")
    public ResponseEntity<List<Library>> searchByAddress(@RequestParam ("address") String address) {
        return ResponseEntity.ok(libraryService.searchByLocation(address + "%"));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Library>> search(@RequestParam("name") String name) {
        return ResponseEntity.ok(libraryService.searchByName(name + "%"));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @RequestBody LibraryModel model) {
        this.libraryService.update(model);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        this.libraryService.delete(id);
    }

    @GetMapping("/image/{id}")
    public ResponseEntity<ByteArrayResource> getImage(@PathVariable("id") UUID id) {
        final byte[] data = imageService.get(id);
        final ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity.ok().contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + id.toString().concat(".jpg") + "\"")
                .body(resource);
    }

}
