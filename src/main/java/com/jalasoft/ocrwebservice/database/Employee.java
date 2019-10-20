package com.jalasoft.ocrwebservice.database;

public class Employee {
    private String employeeID;
    private String name;
    private String lastName;
    private String jobTitle;
    private String hiredDate;
    private String photoPath;

    public String getEmployeeID() {
        return employeeID;
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
        this.employeeID = employeeID;
    }

    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}
