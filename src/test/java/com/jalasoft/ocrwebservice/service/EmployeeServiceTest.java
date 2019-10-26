package com.jalasoft.ocrwebservice.service;

import com.jalasoft.ocrwebservice.controller.Response;
import com.jalasoft.ocrwebservice.database.Employee;
import com.jalasoft.ocrwebservice.exception.ParameterInvalidException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.*;

public class EmployeeServiceTest {
    EmployeeService service;
@Before
public void init(){
    service = new EmployeeService();
}

    @Test
    public void errorWhenAddEmployeeNull() throws ParameterInvalidException {

        Response response = service.addEmployee(null);
        assertEquals( HttpStatus.BAD_REQUEST,response.getHttpStatus());
    }

    @Test
    public void errorWhenUpdateEmployeeNull() throws ParameterInvalidException {
        Response response = service.updateEmployee(null, null);
        assertEquals( HttpStatus.BAD_REQUEST,response.getHttpStatus());
    }

    @Test
    public void validationWhenDeleteEmployeeNonExistent() throws ParameterInvalidException {
        Response response = service.deleteEmployee("20");
        assertEquals( HttpStatus.NOT_FOUND,response.getHttpStatus());
    }
}