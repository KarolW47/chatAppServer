package com.sda.chatappserver.wwkwkdmg.controllers;

import com.sda.chatappserver.wwkwkdmg.model.User;
import com.sda.chatappserver.wwkwkdmg.services.SaveNewUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class UserController {

    private SaveNewUserService createUserService;

    @Autowired
    public UserController(SaveNewUserService createUserService) {
        this.createUserService = createUserService;
    }

    @RequestMapping("indexPage")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping("registerPage")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping
    @RequestMapping("registerUser")
    public String addNewUser(@ModelAttribute User user) {
        createUserService.saveUserToDB(user);
        return "index";
    }
}
