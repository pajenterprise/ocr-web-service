package com.jalasoft.ocrwebservice.controller;

import com.jalasoft.ocrwebservice.database.Employee;
import com.jalasoft.ocrwebservice.service.Cache;
import com.jalasoft.ocrwebservice.service.EmployeeService;
import org.springframework.http.HttpStatus;
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
        //validation
        String auth,token="";
        auth= req.getHeader("Authorization");
        if (auth !=null) {
            token = auth.split(" ")[1];
        }
        if (!Cache.getInstance().isValid(token)){
            ResponseBody body = new ResponseBody<>();
            body.setTextMessage("Authorization header is not present or Token is invalid");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
        }
        //-----------
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
     * Update Employee picture
     * @param photoPath  file.
     * @return Response entity.
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/api/v1/employee/{id}")
    public ResponseEntity<ResponseBody> updatePicture(final @PathVariable String id,
            @RequestParam MultipartFile photoPath) {
        service = new EmployeeService();
        Response response = service.updateEmployee(id, photoPath);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());
    }

    /**
     * Delete an employee
     * @return Response entity.
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/api/v1/employee/{id}")
    public ResponseEntity<ResponseBody> delete(final @PathVariable String id) {
    service = new EmployeeService();
        Response response = service.deleteEmployee(id);
        return ResponseEntity.status(response.getHttpStatus()).body(response.getBody());

    }

}
