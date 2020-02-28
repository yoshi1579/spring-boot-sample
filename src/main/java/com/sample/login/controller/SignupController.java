package com.sample.login.controller;

import com.sample.login.domain.model.GroupOrder;
import com.sample.login.domain.model.SignupForm;
import com.sample.login.domain.model.User;
import com.sample.login.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class SignupController {

    @Autowired
    private UserService userService;

    private Map<String, String> radioMarriage;

    private Map<String, String> initRadioMarriage(){
        Map<String, String> radio = new LinkedHashMap<String, String>();
        radio.put("既婚", "true");
        radio.put("未婚", "true");
        return radio;
    }

    @GetMapping("/signup")
    public String getSignup(@ModelAttribute SignupForm signupForm, Model model){
        radioMarriage = initRadioMarriage();
        model.addAttribute("radioMarriage", radioMarriage);
        return "login/signup";
    }

    @PostMapping("/signup")
    public String postSignup(@ModelAttribute @Validated(GroupOrder.class) SignupForm signupForm, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            return getSignup(signupForm, model);
        }

        System.out.println(signupForm);

        User user = new User();
        user.setId(signupForm.getId());
        user.setName(signupForm.getName());
        user.setAge(signupForm.getAge());
        user.setPassword(signupForm.getPassword());
        user.setUserName(signupForm.getUsername());
        user.setRole("ADMIN");
        Boolean result = userService.insertOne(user);

        if(result) {
            System.out.println("ユーザーの作成に成功");
        } else {
            System.out.println("ユーザーの作成に失敗");
        }
        return "redirect:/login";
    }
}
