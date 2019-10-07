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

import com.jalasoft.ocrwebservice.exception.FileStorageException;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * *
 * This abstract class is our source/destination type of object we want to convert
 *
 */
public abstract class Criteria {
    private File filePath;
    private String fileName;
    private String checksum ="123";

    public Criteria(String sourcePath, String fileName){
        filePath = new File(sourcePath + fileName);
        this.fileName = fileName;
        DBManager db=new DBManager();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            String checksum = md.digest().toString();
        }catch (NoSuchAlgorithmException e){
            new FileStorageException("Error when generating checksum");
        }
        db.addFile(checksum,fileName);
    }

    public File getFile() {
        return filePath;
    }

    public abstract String getAttribute();
    public abstract String getFileName();
}
