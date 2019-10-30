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

import com.jalasoft.ocrwebservice.exception.DBException;
import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
import java.util.List;
/**
 * Framework Strategy: Component context: Define place to execute strategies
 * @author Alejandra Neolopan
 * @version 1.1 26 Oct 2019
 */
public class Context {
    //1st rul: Instance to the strategies
    List<IValidateStrategy> strategyList;
    public Context(List<IValidateStrategy> strategies){
        this.strategyList = strategies;
    }
    //2nd: to have a method execute the strategy
    public void validate() throws ParameterInvalidException, DBException {
        for(IValidateStrategy str:strategyList){
            str.validate();
        }
    }

}
