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
import com.jalasoft.ocrwebservice.database.DBQueryUser;
import com.jalasoft.ocrwebservice.database.User;
import org.springframework.http.HttpStatus;
import java.util.ArrayList;

/**
 * A middleware to verify the validation of users
 * @author Alejandra Neolopan
 * @version 1.1 26 Oct 2019
 */
public class UserService extends Service{

    public String validateUser(User user) {
        Response<User> resp = new Response<User>();
        DBQueryUser dbq = new DBQueryUser();

        if (!dbq.existUser(user.getId(),user.getPassword())) {
            return "Not found";
        }

        String token =TokenService.saveToken(user);
        resp
                .setHttpStatus(HttpStatus.OK)
                .getBody()
                .setTextMessage(token)
                .setData(new ArrayList<>());
        return token;

    }

}
