package com.jalasoft.ocrwebservice.controller;

import com.jalasoft.ocrwebservice.exception.LanguageException;
import com.jalasoft.ocrwebservice.service.FileStorageService;
import com.jalasoft.ocrwebservice.util.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private FileStorageService fileStorageService;

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("lang") String lang) {
        // Verifying the correct language
        if (lang.equalsIgnoreCase(Language.EN.getAbbreviation()) ||
                lang.equalsIgnoreCase(Language.ES.getAbbreviation())) {
            String fileName = fileStorageService.storeFile(file);

            return String.format("The '%s' file was uploaded successfully.", fileName);
        } else {
            throw new LanguageException(String.format("The '%s' language isn't supported.", lang));
        }
    }
}