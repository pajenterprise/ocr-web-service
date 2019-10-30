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

import com.jalasoft.ocrwebservice.database.User;
import com.jalasoft.ocrwebservice.service.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * Service to login.
 */
@RestController
public class LoginController {

    private UserService service;

    /**
     * @return Response entity.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String validate(final @RequestBody @Valid User user)  {
        service= new UserService();
        String token = service.validateUser(user);
        System.out.println("Authenticated");
        return token;
    }
}
