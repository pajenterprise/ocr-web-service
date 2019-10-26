/*
 * Copyright (c) 2019 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jalasoft.
 */
package com.jalasoft.ocrwebservice.controller;

import com.jalasoft.ocrwebservice.database.Employee;
import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
import com.jalasoft.ocrwebservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Employee CRUD
 */
@RestController
public class CRUDController {

    private EmployeeService service;
    /**
     * @return Response entity.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/api/v1/employee")
    public ResponseEntity<ResponseBody> getAll(HttpServletRequest req) {

        service = new EmployeeService();
        Response response = service.getAllEmployees();
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());

    }

    /**
     * @param id String
     * @return Response entity..
     */
   /* @RequestMapping(method = RequestMethod.GET, value = "/api/v1/employee/{id}")
    public ResponseEntity<ResponseBody> getById(final @PathVariable String id) {
        service = new EmployeeService();
        Response response = service.getById(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }*/

    /**
     * @param emp Employee
     * @return Response entity.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/api/v1/employee")
    public ResponseEntity<ResponseBody> add(final @RequestBody @Valid Employee emp) throws ParameterInvalidException {
        service = new EmployeeService();
        Response response = service.addEmployee(emp);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * Update Employee picture
     * @param photoPath  file.
     * @return Response entity.
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/employee/{id}")
    public ResponseEntity<ResponseBody> updatePicture(final @PathVariable String id,
            @RequestParam MultipartFile photoPath) throws ParameterInvalidException {
        service = new EmployeeService();
        Response response = service.updateEmployee(id, photoPath);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * Delete an employee
     * @return Response entity.
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/v1/employee/{id}")
    public ResponseEntity<ResponseBody> delete(final @PathVariable String id) throws ParameterInvalidException {
    service = new EmployeeService();
        Response response = service.deleteEmployee(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());

    }

}
