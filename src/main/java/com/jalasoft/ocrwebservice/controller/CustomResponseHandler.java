package com.jalasoft.ocrwebservice.controller;

import com.jalasoft.ocrwebservice.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomResponseHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MyFileNotFoundException.class)
    public final ResponseEntity<ResponseBody> handleNotFoundException(MyFileNotFoundException ex,
                                                                  WebRequest request) {
        Response exceptionResponse= new Response();
        exceptionResponse.badRequest("File not found or" + ex.getMessage());

        return ResponseEntity.status(exceptionResponse.getHttpStatus()).body(exceptionResponse.getBody());
    }
}