package com.jalasoft.ocrwebservice.service;

import com.jalasoft.ocrwebservice.controller.Response;
import com.jalasoft.ocrwebservice.database.DBQueryUser;
import com.jalasoft.ocrwebservice.database.Employee;
import com.jalasoft.ocrwebservice.database.User;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;


public class MiddlewareService {


    public String validateUser(User user) {

        Response<User> resp = new Response<User>();

        DBQueryUser dbq = new DBQueryUser();


        if (user == null) {
            return "Bad user";
        } else {

            if (!dbq.existUser(user.getId(),user.getPassword())) {
                return "Not found";
            }
        }
        String token =TokenService.saveToken(user);
        System.out.println(token);
        resp
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(token)
                .setData(new ArrayList<>());
        return token;

    }

}
