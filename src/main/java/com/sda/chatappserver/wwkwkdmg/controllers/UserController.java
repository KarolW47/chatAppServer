package com.sda.chatappserver.wwkwkdmg.controllers;

import com.sda.chatappserver.wwkwkdmg.model.User;
import com.sda.chatappserver.wwkwkdmg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/index")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }
}
