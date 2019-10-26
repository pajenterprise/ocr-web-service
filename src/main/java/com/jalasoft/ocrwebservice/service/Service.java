/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.ocrwebservice.service;

import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
import com.jalasoft.ocrwebservice.validation.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Service to handle validate for all services
 * @author Alejandra Neolopan
 * @version 1.1 26 Oct 2019
 */

public class Service<T> {
     private List<IValidateStrategy> val;
    public Service(){
    }

    public void validate(T value, String id) throws ParameterInvalidException {
        val = new ArrayList<>();
        val.add(new NullValidation(value, id));

        if (value instanceof String) {
            val.add(new EmptyValidation((String)value, id));
        }
        Context con = new Context(val);
        con.validate();
    }

}
