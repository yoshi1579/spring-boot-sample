package com.sample.login.controller;

import com.sample.login.domain.model.SignupForm;
import com.sample.login.domain.model.User;
import com.sample.login.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ControllerAdvice
@Component
public class GlobalControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public String illegalArgumentExceptionHandler(IllegalArgumentException e, Model model){
        model.addAttribute("error", "yoshiiiii");
        return "error";
    }
}
