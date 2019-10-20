package com.jalasoft.ocrwebservice.service;

import com.jalasoft.ocrwebservice.controller.Response;
import com.jalasoft.ocrwebservice.database.DBQueryEmployee;
import com.jalasoft.ocrwebservice.database.Employee;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;


public class EmployeeService {
    DBQueryEmployee dbe;
    public EmployeeService(){
        dbe = new DBQueryEmployee();
    }
    public Response getAllEmployees() {
        List<Employee> list = dbe.getAllEmployees();
        Response<Employee> response = new Response<Employee>();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage("Success")
                .setData(list);
        return response;
    }

    public Response getById(String id) {
        return null;
    }

    public Response addEmployee(Employee emp) {
        dbe.insert(emp);
        Response<Employee> response = new Response<Employee>();
        response
                .setHttpStatus(HttpStatus.CREATED)
                .getBody()
                .setTextMessage("created Successfully")
                .setData(new ArrayList<>());
        return response;
    }

    public Response updateEmployee(Employee emp, String id) {
        return null;
    }

    public Response deleteEmployee(String id) {
        return null;
    }
}
