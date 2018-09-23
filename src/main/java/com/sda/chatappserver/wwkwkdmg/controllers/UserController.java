package com.sda.chatappserver.wwkwkdmg.controllers;

import com.sda.chatappserver.wwkwkdmg.model.User;
import com.sda.chatappserver.wwkwkdmg.model.UserStatus;
import com.sda.chatappserver.wwkwkdmg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Optional;

@Controller
@RequestMapping("")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "indexPage")
    public String getIndexPage() {
        return "index";
    }

    @RequestMapping(value = "registerPage")
    public String getRegisterPage() {
        return "register";
    }

    @PostMapping
    @RequestMapping(value = "registerUser")
    public String addNewUser(@ModelAttribute User user, Model model) {
        if (userService.getUserFromDbByLogin(user.getNick()).isPresent()) {
            model.addAttribute("existingLoginMsg", "Podany login juz istnieje!");
            return "register";
        } else {
            userService.saveUserToDB(user);
            return "index";
        }
    }

    @PostMapping
    @RequestMapping(value = "/loginUser")
    public String loginUser(@ModelAttribute User user, Model model, HttpServletResponse response) {
        User userToLogin = userService.getUserFromDbByLoginAndPassword(user.getNick(), user.getPassword());
        if (userToLogin != null) {
            user.setLogStatus(true);
            userService.updateUserStatus(userToLogin.getId(),UserStatus.available);
            Cookie cookie = new Cookie("cookieAppChat", userToLogin.getId().toString());
            response.addCookie(cookie);
            return "redirect:/chatApp";

        } else {
            model.addAttribute("wrongLoginOrPasswordMsg", "Niepoprawny login lub haslo!");
            return "index";
        }
    }

    @RequestMapping(value = "/logOut")
    public String logOutUser(HttpServletRequest request, HttpServletResponse response) {
        Optional<Cookie> myCookie = Arrays.stream(request.getCookies())
                .filter(cookie -> "cookieAppChat".equals(cookie.getName()))
                .findFirst();

        if (myCookie.isPresent()){
            Cookie oldCookie = myCookie.get();
            oldCookie.setMaxAge(0);
            response.addCookie(oldCookie);
            userService.updateUserStatus(Long.parseLong(oldCookie.getValue()), UserStatus.away);
            return "index";
        }else {
            return "index";
        }
    }
}
