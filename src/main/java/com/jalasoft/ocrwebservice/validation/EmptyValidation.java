/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.ocrwebservice.validation;

import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
/**
 * Validate if a string is Empty
 * @author Alejandra Neolopan
 * @version 1.1 26 Oct 2019
 */
public class EmptyValidation implements IValidateStrategy {
    private String value;
    private String parameter;
    public EmptyValidation(String value, String id){

        this.value=value;
        this.parameter=id;
    }

    @Override
    public boolean validate() throws ParameterInvalidException {
        if(this.value == "") {
            throw new ParameterInvalidException(11, parameter);
        }
        return  true;

    }
}
