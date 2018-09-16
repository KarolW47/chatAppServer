package com.sda.chatappserver.wwkwkdmg.controllers;

import com.sda.chatappserver.wwkwkdmg.model.User;
import com.sda.chatappserver.wwkwkdmg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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
        userService.saveUserToDB(user);
        return "index";
    }

    @PostMapping
    @RequestMapping(value = "/loginUser")
    public String loginUser(@ModelAttribute User user, HttpServletResponse response) {
        User userToLogin = userService.getUserFromDb(user.getNick(), user.getPassword());
        if (userToLogin != null) {
            user.setLogStatus(true);
            Cookie cookie = new Cookie("cookieAppChat", userToLogin.getId().toString());
            response.addCookie(cookie);
            return "redirect:/chatApp";

        } else {
            return "index";
        }

    }
}
