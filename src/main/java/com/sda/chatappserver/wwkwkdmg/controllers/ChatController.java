package com.sda.chatappserver.wwkwkdmg.controllers;

import com.sda.chatappserver.wwkwkdmg.model.Message;
import com.sda.chatappserver.wwkwkdmg.services.MessageService;
import com.sda.chatappserver.wwkwkdmg.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ChatController {

    private UserService userService;
    private MessageService messageService;

    public ChatController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @RequestMapping("/chatApp")
    public String displayMessages(Model model) {
        List<Message> messageList = messageService.getAllMessages();
        Collections.reverse(messageList);
        List<Message> limitedMessageList = messageList.stream().limit(25).collect(Collectors.toList());
        Collections.reverse(limitedMessageList);
        model.addAttribute("messages", limitedMessageList);
        model.addAttribute("users", userService.getUserListFromDb());
        return "chatApp";
    }
}
