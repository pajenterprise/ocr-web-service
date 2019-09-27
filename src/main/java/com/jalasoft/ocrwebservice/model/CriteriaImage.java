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
 * Criteria Image (file png/jgp/tif)
 *
 */
public class CriteriaImage extends Criteria{
    private String fileName;

    public CriteriaImage(String sourcePath, String fileName) {
        super(sourcePath, fileName);
        this.fileName = fileName;

    }

    @Override
    public String getAttribute() {
        return null;
    }

    @Override
    public String getFileName() {
        return this.fileName;
    }
}
