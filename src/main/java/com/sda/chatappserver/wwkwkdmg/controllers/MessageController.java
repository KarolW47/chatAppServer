package com.sda.chatappserver.wwkwkdmg.controllers;

import com.sda.chatappserver.wwkwkdmg.model.Message;
import com.sda.chatappserver.wwkwkdmg.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping("/showMessage")
    public String displayMessages(@ModelAttribute Model model) {
        List<Message> messages = messageService.getAllMessages();
        messages.stream().limit(4);
        model.addAttribute("messages", messages);
        return "chatApp";
    }

    @PostMapping
    @RequestMapping("/addMessage")
    public String addChatMessage(@ModelAttribute String messageToAdd, HttpServletRequest request) {
        String idFromCookie = "";
        Optional<Cookie> first = Arrays.stream(request.getCookies())
                .filter(cookie -> "cookieAppChat".equals(cookie.getName()))
                .findFirst();

        if (first.isPresent()) {
            idFromCookie = first.get().getValue();

            Message message = new Message();
            message.setText(messageToAdd);
            message.setMessageDate(LocalDateTime.now());
            message.setRecipient(1L);
            message.setSender(Long.parseLong(idFromCookie));
            message.setMessageStatus(null);
            messageService.saveMessageToDB(message);
        }
        return "chatApp";
    }
}
