package com.jalasoft.ocrwebservice.validation;

import com.jalasoft.ocrwebservice.exception.DBException;
import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;

public interface IValidateStrategy {
    boolean validate() throws ParameterInvalidException, DBException;
}
