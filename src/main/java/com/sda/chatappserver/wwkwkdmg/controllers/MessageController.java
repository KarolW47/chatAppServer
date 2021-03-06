package com.sda.chatappserver.wwkwkdmg.controllers;

import com.sda.chatappserver.wwkwkdmg.model.Message;
import com.sda.chatappserver.wwkwkdmg.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

@Controller
public class MessageController {

    private MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    @RequestMapping("/addMessage")
    public String addChatMessage(@RequestParam String messageToAdd, HttpServletRequest request) {
        String idFromCookie = "";
        Optional<Cookie> firstMatchingCookie = Arrays.stream(request.getCookies())
                .filter(cookie -> "cookieAppChat".equals(cookie.getName()))
                .findFirst();

        if (firstMatchingCookie.isPresent()) {
            idFromCookie = firstMatchingCookie.get().getValue();

            Message message = new Message();
            message.setText(messageToAdd);
            message.setMessageDate(LocalDateTime.now());
            message.setRecipient(1L);
            message.setSender(Long.parseLong(idFromCookie));
            message.setMessageStatus(null);
            messageService.saveMessageToDB(message);

            return "redirect:/chatApp";
        }else {
            return "index";
        }
    }
}
