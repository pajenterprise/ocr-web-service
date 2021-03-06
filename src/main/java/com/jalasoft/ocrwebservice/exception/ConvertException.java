/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.ocrwebservice.exception;
/**
 * Throws an error in the conversion
 */
public class ConvertException extends Exception {
    public ConvertException(String msg, Throwable e){
        super(msg,e);
    }
}
