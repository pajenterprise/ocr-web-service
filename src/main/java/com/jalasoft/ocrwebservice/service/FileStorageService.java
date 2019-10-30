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

import com.jalasoft.ocrwebservice.exception.DBException;
import com.jalasoft.ocrwebservice.exception.FileStorageException;
import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
import com.jalasoft.ocrwebservice.validation.Context;
import com.jalasoft.ocrwebservice.validation.IValidateStrategy;
import com.jalasoft.ocrwebservice.validation.NullValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import static com.jalasoft.ocrwebservice.util.Constant.RESOURCE_DIR;
/**
 * Files management
 * @author Alejandra Neolopan
 * @version 1.1 26 Oct 2019
 */
@Service
public class FileStorageService {

    private final Path fileStorageLocation;

    @Autowired
    public FileStorageService() {

        this.fileStorageLocation = Paths.get(RESOURCE_DIR);

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }
/**
 * Copies the uploaded file to a local path and return path
 */
    public String storeFile(MultipartFile file) throws ParameterInvalidException, DBException {
        validate (file);
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

            return targetLocation.toAbsolutePath().normalize().toString();
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }


    /**
     * Copies the uploaded file with a new id as filename
     */
    public String storeFile(MultipartFile file, String id) throws ParameterInvalidException, DBException {
        validate (file);
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String[] fileNameSplits = fileName.split("\\.");
            Path newPath = targetLocation.resolveSibling(id + "." + fileNameSplits[fileNameSplits.length - 1]);
            Files.move(targetLocation, newPath, StandardCopyOption.REPLACE_EXISTING);
            return id + "." + fileNameSplits[fileNameSplits.length - 1];
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }


    }
    private void validate(MultipartFile item) throws ParameterInvalidException, DBException {
        List<IValidateStrategy> val;
        val = new ArrayList<>();
        val.add(new NullValidation(item, "file"));
        Context con = new Context(val);
        con.validate();
    }
}
