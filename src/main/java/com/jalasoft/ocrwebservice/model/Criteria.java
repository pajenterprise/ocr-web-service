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

import java.io.File;

/**
 * *
 * This abstract class is our source/destination type of object we want to convert
 *
 */
public abstract class Criteria {
    private File filePath;
    private String fileName;

    public Criteria(String sourcePath, String fileName){
        filePath = new File(sourcePath + fileName);
        this.fileName = fileName;
    }

    public File getFile() {
        return filePath;
    }

    public abstract String getAttribute();
    public abstract String getFileName();
}
