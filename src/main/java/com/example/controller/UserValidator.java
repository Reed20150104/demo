package com.example.controller;

import com.example.domain.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by reed on 2017/4/25.
 */
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User u = (User) target;

        if(u != null && StringUtils.isEmpty(u.getPassword())) {
            errors.rejectValue("password",null,null,"密码不能为空");
        }

        if(!isDigit(u.getWork_id())) {
            errors.rejectValue("work_id",null,null,"工号非法");
        }
    }
    public boolean isDigit(String strNum) {
        return strNum.matches("[0-9]{6}");
    }
}
