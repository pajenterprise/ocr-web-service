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

import com.jalasoft.ocrwebservice.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
/**
 * Custom response to handle the Exceptions thrown
 * @author Alejandra Neolopan
 * @version 1.1 26 Oct 2019
 */
@ControllerAdvice
@RestController
public class CustomResponseHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MyFileNotFoundException.class)
    public final ResponseEntity<ResponseBody> handleNotFoundException(MyFileNotFoundException ex,
                                                                      WebRequest request) {
        Response exceptionResponse = new Response();
        exceptionResponse
                .setHttpStatus(HttpStatus.BAD_REQUEST)
                .getBody()
                .setTextMessage("File not found")
                .setData(new ArrayList<>());

        return ResponseEntity.status(exceptionResponse.getHttpStatus()).body(exceptionResponse.getBody());
    }

    @ExceptionHandler(ParameterInvalidException.class)
    public final ResponseEntity<ResponseBody> invalidParams(ParameterInvalidException ex,
                                                            WebRequest request) {
        Response exceptionResponse = new Response();
        exceptionResponse
                .setHttpStatus(HttpStatus.BAD_REQUEST)
                .getBody()
                .setTextMessage(ex.getMessage())
                .setData(new ArrayList<>());

        return ResponseEntity.status(exceptionResponse.getHttpStatus()).body(exceptionResponse.getBody());
    }

    @ExceptionHandler(LanguageException.class)
    public final ResponseEntity<ResponseBody> invalidLanguage(LanguageException ex,
                                                              WebRequest request) {
        Response exceptionResponse = new Response();
        exceptionResponse
                .setHttpStatus(HttpStatus.BAD_REQUEST)
                .getBody()
                .setTextMessage("Language not supported")
                .setData(new ArrayList<>());

        return ResponseEntity.status(exceptionResponse.getHttpStatus()).body(exceptionResponse.getBody());
    }

    @ExceptionHandler(ConvertException.class)
    public final ResponseEntity<ResponseBody> conversionError(ConvertException ex,
                                                              WebRequest request) {
        Response exceptionResponse = new Response();
        exceptionResponse
                .setHttpStatus(HttpStatus.BAD_REQUEST)
                .getBody()
                .setTextMessage("Conversion exception")
                .setData(new ArrayList<>());

        return ResponseEntity.status(exceptionResponse.getHttpStatus()).body(exceptionResponse.getBody());
    }

    @ExceptionHandler(FileStorageException.class)
    public final ResponseEntity<ResponseBody> fileStorageHandle(FileStorageException ex,
                                                                WebRequest request) {
        Response exceptionResponse = new Response();
        exceptionResponse
                .setHttpStatus(HttpStatus.CONFLICT)
                .getBody()
                .setTextMessage("An error occurred saving file")
                .setData(new ArrayList<>());

        return ResponseEntity.status(exceptionResponse.getHttpStatus()).body(exceptionResponse.getBody());
    }
}