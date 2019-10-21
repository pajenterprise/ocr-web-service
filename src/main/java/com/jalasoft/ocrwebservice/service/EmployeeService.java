package com.jalasoft.ocrwebservice.service;

import com.jalasoft.ocrwebservice.controller.Response;
import com.jalasoft.ocrwebservice.database.DBQueryEmployee;
import com.jalasoft.ocrwebservice.database.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;


public class EmployeeService {
    DBQueryEmployee dbe;

    @Autowired
    private FileStorageService fileStorageService;

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

    public Response updateEmployee(String id, MultipartFile file) {
        fileStorageService = new FileStorageService();
        String path = fileStorageService.storeFile(file, id);
        dbe.updatePath(id,path);
        Response<Employee> response = new Response<Employee>();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage("employee " + id + "'s picture submitted to " + path)
                .setData(new ArrayList<>());
        return response;
    }

    public Response deleteEmployee(String id) {
        dbe.deleteEmployee(id);

        Response<Employee> response = new Response<Employee>();
        response
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage("deleted Successfully")
                .setData(new ArrayList<>());
        return response;
    }
}
