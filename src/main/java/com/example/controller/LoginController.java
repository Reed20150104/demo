package com.example.controller;

import com.example.domain.User;
import com.example.service.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by reed on 2017/4/18.
 */
@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private UserManager userManager;

    @RequestMapping(method= RequestMethod.GET)
    public String login() {
        return "index";
    }

    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public String submit(Model model, @Valid User user, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {

        }

        String userWorkId = user.getWork_id();
        User userlogin=userManager.getUserByWork_id(userWorkId);
        if(bindingResult.hasErrors()) {
           List<ObjectError> allErrors= bindingResult.getAllErrors();
           for(ObjectError obr:allErrors) {
               System.out.println(new String(obr.getDefaultMessage()));
           }


       }
       if(userlogin.getPassword().equals(user.getPassword())) {
           return "home";
       }
       return "index";
    }

    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.replaceValidators(new UserValidator());
    }
}
