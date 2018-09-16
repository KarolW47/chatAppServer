package com.sda.chatappserver.wwkwkdmg.services;

import com.sda.chatappserver.wwkwkdmg.model.Message;

import java.util.List;

public interface MessageService {

    List<Message> getAllMessages();

    Message saveMessageToDB(Message message);
}
