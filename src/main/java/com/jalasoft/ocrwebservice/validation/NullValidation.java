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
 * Validate if a parameter is null
 * @author Alejandra Neolopan
 * @version 1.1 26 Oct 2019
 */

public class NullValidation<T> implements IValidateStrategy {
    private T value;
    private String parameter;

    public NullValidation(T value, String item){
        this.value=value;
        this.parameter=item;
    }

    @Override
    public boolean validate() throws ParameterInvalidException {
        if(null == this.value) {
            throw new ParameterInvalidException(10,parameter);
        }
        return  true;

    }
}
