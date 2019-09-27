package com.jalasoft.ocrwebservice.model;

/*
 * IConvert
 * Version 1
 * Date 09/23/2019
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */

/**
 * *
 * Criteria Text (file txt) language
 * fra - France
 * eng - English
 * spa - Spanish
 * por - Portuguese
 */
public class CriteriaText extends Criteria {
    private String fileName;
    private String lang;
    public CriteriaText(String sourcePath, String fileName, String language) {
        super(sourcePath, fileName);
        this.fileName = fileName;
        lang = language;
    }
    @Override
    public String getAttribute() {
        return lang;
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }

}
