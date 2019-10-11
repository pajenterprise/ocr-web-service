package com.jalasoft.ocrwebservice.controller;

import com.jalasoft.ocrwebservice.exception.LanguageException;
import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
import com.jalasoft.ocrwebservice.model.ConvertImageToText;
import com.jalasoft.ocrwebservice.model.Criteria;
import com.jalasoft.ocrwebservice.model.CriteriaText;
import com.jalasoft.ocrwebservice.service.FileStorageService;
import com.jalasoft.ocrwebservice.util.Language;
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

    @PostMapping("/api/v1/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file,
                             @RequestParam("lang") String lang) {
        try {
            // Verifying the correct language
            if (lang.equalsIgnoreCase(Language.EN.getAbbreviation()) ||
                    lang.equalsIgnoreCase(Language.ES.getAbbreviation())) {
                String fileName = fileStorageService.storeFile(file);

                Criteria image = new CriteriaText(RESOURCE_DIR, fileName, lang);
                image.validate();
                ConvertImageToText test = new ConvertImageToText();
                String textResult = test.Convert(image);

                return String.format("The '%s' file was uploaded successfully.\n'%s'", fileName, textResult);
            } else {
                throw new LanguageException(String.format("The '%s' language isn't supported.", lang));
            }
        }catch (ParameterInvalidException e){
            System.out.println("Param");
            return ("Some parameters are invalid");
           //return (e.getMessage());
        }catch (Exception other){
            System.out.println("An error");
            return (other.getMessage());
        }
        finally {
            return ":)";
        }
    }
}