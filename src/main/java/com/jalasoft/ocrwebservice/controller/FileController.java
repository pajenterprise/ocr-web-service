package com.jalasoft.ocrwebservice.controller;

import com.jalasoft.ocrwebservice.exception.LanguageException;
import com.jalasoft.ocrwebservice.model.*;
import com.jalasoft.ocrwebservice.service.FileStorageService;
import com.jalasoft.ocrwebservice.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.jalasoft.ocrwebservice.util.Constant.RESOURCE_DIR;

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

            Criteria image = new CriteriaText(RESOURCE_DIR, fileName, lang);
            ConvertImageToText test = new ConvertImageToText();
            String textResult = test.Convert(image);

            return String.format("The '%s' file was uploaded successfully.\n'%s'", fileName, textResult);
        } else {
            throw new LanguageException(String.format("The '%s' language isn't supported.", lang));
        }
    }
    @PostMapping("/convertPDF2Image")
    public String uploadPDF(@RequestParam("file") MultipartFile file,
                            @RequestParam(value = "type", defaultValue = "jpg") String type,
                            @RequestParam(value = "width", defaultValue = "600") int width,
                            @RequestParam(value="height", defaultValue = "800") int height) {
        // Verifying the correct type
        if (type.equalsIgnoreCase(ImageType.JPG.getExtension()) ||
                type.equalsIgnoreCase(ImageType.PNG.getExtension()) ||
                type.equalsIgnoreCase(ImageType.TIF.getExtension()) ||
                type.equalsIgnoreCase(ImageType.BMP.getExtension())  ) {
            String fileName = fileStorageService.storeFile(file);
          //  Criteria pdf = new CriteriaPDF(RESOURCE_DIR , fileName);
           // ConvertImageToText test = new ConvertImageToText();
         //   String textResult = test.Convert(image);
            String textResult ="/public/result."+type;
            return String.format("The '%s' file was converted successfully. \n'%s'", fileName, textResult);
        } else {
            throw new LanguageException(String.format("The '%s' file type isn't supported.", type));
        }
    }
}