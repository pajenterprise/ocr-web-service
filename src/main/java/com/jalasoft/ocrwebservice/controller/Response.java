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

import org.springframework.http.HttpStatus;

import java.util.List;

/**
 * Class Response to handle HTTP Code Responses
 */
public class Response<T> {

    private HttpStatus status;
    private ResponseBody<T> body;

    /**
     * Constructor.
     */
    public Response() {
        body = new ResponseBody<>();
    }

    /**
     * @return httpStatus.
     */
    public HttpStatus getHttpStatus() {
        return status;
    }

    /**
     * @param httpStatus httpStatus.
     * @return Response.
     */
    public Response<T> setHttpStatus(final HttpStatus httpStatus) {
        this.status = httpStatus;
        return this;
    }


    /**
     * @return Response.
     */
    public ResponseBody<T> getBody() {
        return body;
    }

    /**
     * @param body body.
     * @return Response.
     */
    public Response<T> setBody(final ResponseBody<T> body) {
        this.body = body;
        return this;
    }
    public Response NotFound(String item) {
        this.status= HttpStatus.NOT_FOUND;
        body.setTextMessage( item + " was not found");
        return this;
    }

    public Response badRequest(String item) {
        this.status= HttpStatus.BAD_REQUEST;
        body.setTextMessage( item + " incorrect");
        return this;
    }

    public Response OK(String valid_user) {
        this.status= HttpStatus.OK;
        body.setTextMessage("Success");
        System.out.println("Success");
        return this;
    }
}




