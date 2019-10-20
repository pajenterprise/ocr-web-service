package com.jalasoft.ocrwebservice.controller;

import com.jalasoft.ocrwebservice.database.Employee;
import com.jalasoft.ocrwebservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<ResponseBody> getAll() {
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
    public ResponseEntity<ResponseBody> add(final @RequestBody @Valid Employee emp) {
        service = new EmployeeService();
        Response response = service.addEmployee(emp);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param emp Employee data updates
     * @param id   id.
     * @return Response entity.
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/employee/{id}")
    public ResponseEntity<ResponseBody> update(final @RequestBody @Valid Employee emp, final @PathVariable String id) {
        service = new EmployeeService();
        Response response = service.updateEmployee(emp, id);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * @param id String
     * @return Response entity.
     */
    /*@RequestMapping(method = RequestMethod.DELETE, value = "/api/v1/employee/{id}")
    public ResponseEntity<ResponseBody> delete(final @PathVariable String id) {
    service = new EmployeeService();
        Response response = service.deleteEmployee(id);
        return new ResponseEntity<>(response, response.getHttpCodeMessage());

    }
    */
}
