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

import com.jalasoft.ocrwebservice.database.DBQueryEmployee;
import com.jalasoft.ocrwebservice.exception.DBException;
import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
/**
 * Verifies Employee Id exist in db
 * @author Alejandra Neolopan
 * @version 1.1 26 Oct 2019
 */
public class EmployeeIDValidation implements IValidateStrategy {
    private String value;
    private String parameter;
    public EmployeeIDValidation(String value, String parameter){
        this.value=value;
        this.parameter=parameter;
    }

    @Override
    public boolean validate() throws ParameterInvalidException, DBException {
        DBQueryEmployee dbq = new DBQueryEmployee();
        if(dbq.existEmployee(value)) {
            return true;
        }
        throw new ParameterInvalidException(12,"Employee ID");

    }
}
