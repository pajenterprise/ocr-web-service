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

import com.jalasoft.ocrwebservice.exception.LanguageException;
import java.util.ArrayList;
import java.util.List;
/**
 * Validate if language is supported
 * @author Alejandra Neolopan
 * @version 1.1 26 Oct 2019
 */
public class LangValidation implements IValidateStrategy{
    private List<String> langs;
    private String value;
    public LangValidation(String value){
        this.value=value;
        langs = new ArrayList<>();
        langs.add("eng");
        langs.add("por");
    }

    @Override
    public boolean validate() {
        if(langs.contains(this.value)){
            return true;
        }
        throw new LanguageException("language " + value + " not supported");
    }
}
