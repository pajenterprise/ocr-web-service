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

import com.jalasoft.ocrwebservice.controller.Response;
import com.jalasoft.ocrwebservice.database.DBQueryEmployee;
import com.jalasoft.ocrwebservice.database.Employee;
import com.jalasoft.ocrwebservice.exception.DBException;
import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
import com.jalasoft.ocrwebservice.util.Constant;
import com.jalasoft.ocrwebservice.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles responses for end points
 * @author Alejandra Neolopan
 * @version 1.1 26 Oct 2019
 */
public class EmployeeService extends Service{
    private DBQueryEmployee dbe;
    @Autowired
    private FileStorageService fileStorageService;

    public EmployeeService(){

        dbe = new DBQueryEmployee();
    }
    public Response getAllEmployees() throws DBException {
        List<Employee> list = dbe.getAllEmployees();
        Response<Employee> response = new Response<Employee>();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage("Success")
                .setData(list);
        return response;
    }

    public Response getById(String id) throws ParameterInvalidException, DBException {
        Response<Employee> response = new Response<Employee>();
        validateEmployee(id);
        List<Employee> list = dbe.getById(id);

        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage("Success")
                .setData(list);
        return response;
    }
    public Response updateEmployee(Employee emp) throws ParameterInvalidException, DBException {
        Response<Employee> response = new Response<Employee>();
        validateEmployeeData(emp);
        dbe.update(emp);

        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage("updated Successfully")
                .setData(new ArrayList<>());
        return response;
    }
    public Response addEmployee(Employee emp) throws ParameterInvalidException, DBException {
        Response<Employee> response = new Response<Employee>();
        validateEmployeeData(emp);
        dbe.insert(emp);

        response
                .setHttpStatus(HttpStatus.CREATED)
                .getBody()
                .setTextMessage("created Successfully")
                .setData(new ArrayList<>());
        return response;
    }

    public Response updateEmployeePhoto(String id, MultipartFile file) throws ParameterInvalidException, DBException {
        Response<String> response = new Response<String>();
        validateEmployee(id);
        validate(file, "Photo");
        fileStorageService = new FileStorageService();
        String filename = fileStorageService.storeFile(file, id);
        String path = UriComponentsBuilder.newInstance()
                .scheme(Constant.SCHEME).host(Constant.HOST)
                .path("/api/v1/download/file/{fileName:.+}")
                .buildAndExpand(filename)
                .toString();
        dbe.updatePath(id, path);
        List<String> url= new ArrayList<>();
        url.add(path);
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage("Updated successfully")
                .setData(url);

        return response;
    }

    public Response deleteEmployee(String id) throws ParameterInvalidException, DBException {
        Response<Employee> response = new Response<Employee>();
        validateEmployee(id);
        dbe.deleteEmployee(id);
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage("deleted Successfully")
                .setData(new ArrayList<>());

        return response;
    }
    private void validateEmployee(String value) throws ParameterInvalidException, DBException {
        List<IValidateStrategy> val  = new ArrayList<>();
        val.add(new NullValidation(value, "Employee Id"));
        val.add(new EmployeeIDValidation((String) value, "Employee ID"));
        Context con = new Context(val);
        con.validate();
    }
    private void validateEmployeeData(Employee emp) throws ParameterInvalidException, DBException {
        List<IValidateStrategy> val  = new ArrayList<>();
        val.add(new NullValidation(emp.getEmployeeID(), "Employee Id"));
        val.add(new NullValidation(emp.getName(), "Employee Name"));
        val.add(new EmptyValidation(emp.getEmployeeID(), "Employee Id"));
        val.add(new EmptyValidation(emp.getName(), "Employee Name"));

        Context con = new Context(val);
        con.validate();
    }

}
