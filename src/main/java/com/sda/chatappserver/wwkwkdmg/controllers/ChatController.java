package com.sda.chatappserver.wwkwkdmg.controllers;

import com.sda.chatappserver.wwkwkdmg.model.FixedMessage;
import com.sda.chatappserver.wwkwkdmg.services.FixedMessageService;
import com.sda.chatappserver.wwkwkdmg.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        List<FixedMessage> fixedMessageList = fixedMessageService.getFixedMessages();
        Collections.reverse(fixedMessageList);
        List<FixedMessage> limitedMessageList = fixedMessageList.stream().limit(25).collect(Collectors.toList());
        Collections.reverse(limitedMessageList);

        model.addAttribute("messages", limitedMessageList);
        model.addAttribute("users", userService.getUserListFromDb());
        return "chatApp";
    }

}
