package com.library.librarywebapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
@Service
public class ImageService {
    public UUID save(MultipartFile file) {
        UUID objectKey = UUID.randomUUID();
        try {

            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(objectKey + file.getOriginalFilename());
            Files.write(path, bytes);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return objectKey;

    }
}
