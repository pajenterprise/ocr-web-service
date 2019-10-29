/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.ocrwebservice.controller;

import com.jalasoft.ocrwebservice.exception.DBException;
import com.jalasoft.ocrwebservice.exception.LanguageException;
import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
import com.jalasoft.ocrwebservice.service.FileStorageService;
import com.jalasoft.ocrwebservice.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PDFController {
    private static final Logger logger = LoggerFactory.getLogger(OCRController.class);

    @Autowired
    private FileStorageService fileStorageService;
    @PostMapping("/api/v1/convertPDF2Image")
    public String uploadPDF(@RequestParam("file") MultipartFile file,
                            @RequestParam(value = "type", defaultValue = "jpg") String type,
                            @RequestParam(value = "width", defaultValue = "600") int width,
                            @RequestParam(value = "height", defaultValue = "800") int height) throws ParameterInvalidException, DBException {
        // Verifying the correct type
        if (type.equalsIgnoreCase(ImageType.JPG.getExtension()) ||
                type.equalsIgnoreCase(ImageType.PNG.getExtension()) ||
                type.equalsIgnoreCase(ImageType.TIF.getExtension()) ||
                type.equalsIgnoreCase(ImageType.BMP.getExtension())  ) {
            String fileName = fileStorageService.storeFile(file);
            //  Criteria pdf = new CriteriaPDF(RESOURCE_DIR , fileName);
            // ConvertImageToText test = new ConvertImageToText();
            //   String textResult = test.Convert(image);
            String textResult ="C:/users/user.m1/Documents/ocr-webservice/public/result."+type;
            return String.format("The '%s' file was converted successfully. \n'%s'", fileName, textResult);
        } else {
            throw new LanguageException(String.format("The '%s' file type isn't supported.", type));
        }
    }
}
