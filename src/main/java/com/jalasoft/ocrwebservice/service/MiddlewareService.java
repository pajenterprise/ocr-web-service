package com.jalasoft.ocrwebservice.service;

import com.jalasoft.ocrwebservice.controller.Response;
import com.jalasoft.ocrwebservice.database.DBQueryUser;
import com.jalasoft.ocrwebservice.database.User;


public class MiddlewareService {


    public Response validateUser(User user) {
        Response resp = new Response();
        DBQueryUser dbq = new DBQueryUser();


        if (user == null) {
            return resp.badRequest("User");
        } else {

            if (!dbq.existUser(user.getId(),user.getPassword())) {
                return resp.NotFound("User");
            }
        }
        TokenService.saveToken(user);
        System.out.println("Token saved");
        return resp.OK("Valid User");
    }

}
