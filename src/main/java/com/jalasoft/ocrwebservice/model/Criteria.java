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
package com.jalasoft.ocrwebservice.model;

import com.jalasoft.ocrwebservice.exception.FileStorageException;
import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
import com.jalasoft.ocrwebservice.validation.Context;
import com.jalasoft.ocrwebservice.validation.IValidateStrategy;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * *
 * This abstract class is our source/destination type of object we want to convert
 *
 */
public abstract class Criteria {
    private File filePath;
    private String fileName;
    private String checksum ="123";
    List<IValidateStrategy> val;

    public Criteria(String fileName){
        val = new ArrayList<>();
        filePath = new File( fileName);
        System.out.println("filepath: " +filePath);
        this.fileName = fileName;
        DBManager db=new DBManager();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            checksum = md.digest().toString();
            System.out.println("checksum" + checksum);
        }catch (NoSuchAlgorithmException e){
            new FileStorageException("Error when generating checksum");
        }
        db.addFile(checksum,fileName);
    }

    public Criteria() {
        val = new ArrayList<>();
    }

    public File getFile() {
        return filePath;
    }

    public abstract String getAttribute();
    public abstract String getFileName();

    public void validate() throws ParameterInvalidException {
        Context context = new Context(val);
        context.validate();
    }
}
