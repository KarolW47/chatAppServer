package com.sda.chatappserver.wwkwkdmg.controllers;

import com.sda.chatappserver.wwkwkdmg.model.FixedMessage;
import com.sda.chatappserver.wwkwkdmg.services.FixedMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageDispatcher {

    private FixedMessageService fixedMessageService;

    @Autowired
    public MessageDispatcher(FixedMessageService fixedMessageService) {
        this.fixedMessageService = fixedMessageService;
    }

    @GetMapping(value = "chatApp/messages", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FixedMessage> getMainWindowMessages() {
        return fixedMessageService.getFixedMessages();
    }
}
