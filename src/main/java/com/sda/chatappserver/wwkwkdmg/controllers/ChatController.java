package com.sda.chatappserver.wwkwkdmg.controllers;

import com.sda.chatappserver.wwkwkdmg.services.FixedMessageService;
import com.sda.chatappserver.wwkwkdmg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {

    private UserService userService;
    private FixedMessageService fixedMessageService;

    @Autowired
    public ChatController(UserService userService, FixedMessageService fixedMessageService) {
        this.userService = userService;
        this.fixedMessageService = fixedMessageService;
    }

    @RequestMapping("/chatApp")
    public String displayMessages(Model model) {
        model.addAttribute("users", userService.getUserListFromDb());
        return "chatApp";
    }

}
