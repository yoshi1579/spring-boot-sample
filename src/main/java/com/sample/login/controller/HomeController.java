package com.sample.login.controller;

import com.sample.login.domain.model.GroupOrder;
import com.sample.login.domain.model.SignupForm;
import com.sample.login.domain.model.User;
import com.sample.login.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String getHome(@ModelAttribute SignupForm signupForm, Model model){
        List<User> users = userService.selectMany();
        Integer count = userService.count();
        model.addAttribute("users", users);
        model.addAttribute("count", count);
        return "/home";
    }

    @GetMapping("/userEdit/{id:.+}")
    public String getUserEdit(Model model, @PathVariable("id") Integer id){
        if (id != null) {
            User user = userService.selectOne(id);
            model.addAttribute("user", user);
        }

        return "/userEdit";
    }

    @PatchMapping("/users/{id}")
    public String patchUser(@ModelAttribute SignupForm signupForm, @PathVariable("id") Integer id, Model model){
        throw new IllegalArgumentException("Error");
//        if (id != null) {
//            User user = userService.selectOne(id);
//            user.setPassword(signupForm.getPassword());
//            boolean result = userService.updateOne(user);
//            model.addAttribute("result", result);
//        }
//
//        return "/home";
    }
}
