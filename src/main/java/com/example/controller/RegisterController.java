package com.example.controller;

import com.example.domain.User;
import com.example.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by reed on 2017/4/21.
 */
@Controller
public class RegisterController {

    @Autowired
    private UserManager userManager;
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public String register(User user) {
        System.out.println(user.getWork_id());
        System.out.println(user.getPassword());
        System.out.println(user.getMail());
        userManager.insertUser(user);

       return "index";
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators();
    }
}
