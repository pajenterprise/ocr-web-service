/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.ocrwebservice.database;
/**
 * Employee abstraction
 * @author Alejandra Neolopan
 * @version 1.1 26 Oct 2019
 */
public class Employee {
    private String employeeId;
    private String name;
    private String lastName;
    private String jobTitle;
    private String hiredDate;
    private String photoPath;

    public String getEmployeeID() {
        return employeeId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getHiredDate() {
        return hiredDate;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeId = employeeID;
    }

    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
