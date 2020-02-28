package com.sample.login.controller;

import com.sample.login.domain.model.GroupOrder;
import com.sample.login.domain.model.SignupForm;
import com.sample.login.domain.model.User;
import com.sample.login.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/signup")
    public String postUserSignup(@ModelAttribute User user, BindingResult bindingResult, Model model){

        userService.insertOne(user);

        return "/user/signup";
    }
}
