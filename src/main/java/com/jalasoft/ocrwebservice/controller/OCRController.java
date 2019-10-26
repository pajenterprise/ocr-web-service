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

import com.jalasoft.ocrwebservice.exception.ConvertException;
import com.jalasoft.ocrwebservice.exception.LanguageException;
import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
import com.jalasoft.ocrwebservice.model.OCRConvert;
import com.jalasoft.ocrwebservice.model.Criteria;
import com.jalasoft.ocrwebservice.model.CriteriaText;
import com.jalasoft.ocrwebservice.service.FileStorageService;
import com.jalasoft.ocrwebservice.service.OCRService;
import com.jalasoft.ocrwebservice.util.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.jalasoft.ocrwebservice.util.Constant.RESOURCE_DIR;
/**
 * OCR Controller to convert images to text
 */
@RestController
public class OCRController {

    private static final Logger logger = LoggerFactory.getLogger(OCRController.class);


    @PostMapping("/api/v1/uploadFile")
    public ResponseEntity<ResponseBody> uploadFile(@RequestParam("file") MultipartFile file,
                                                   @RequestParam("lang") String lang) throws ConvertException, ParameterInvalidException {
        OCRService service= new OCRService();
        Response response = service.convert(file,lang);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());

    }
}