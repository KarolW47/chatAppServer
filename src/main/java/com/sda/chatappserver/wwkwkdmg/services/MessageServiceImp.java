package com.sda.chatappserver.wwkwkdmg.services;

import com.sda.chatappserver.wwkwkdmg.model.Message;
import com.sda.chatappserver.wwkwkdmg.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImp implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImp(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public List<Message> getAllMessages() {
        List<Message> messageList = new ArrayList<>();
        messageRepository.findAll().forEach(msg -> messageList.add(msg));
        return messageList;
    }

    @Override
    public Message saveMessageToDB(Message message) {
        return messageRepository.save(message);
    }
}
