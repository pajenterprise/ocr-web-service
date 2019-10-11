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

/**
 * Class Response to handle HTTP Code Responses
 */
public class Response {

    private String message;
    private String details;
    private String httpCodeMessage;
    public Response(String message, String details,String httpCodeMessage) {
        super();

        this.message = message;
        this.details = details;
        this.httpCodeMessage=httpCodeMessage;
    }
    public String getHttpCodeMessage() {
        return httpCodeMessage;
    }
     public String getMessage() {
        return message;
    }
    public String getDetails() {
        return details;
    }
}
