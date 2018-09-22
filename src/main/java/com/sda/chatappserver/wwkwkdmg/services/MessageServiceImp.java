package com.sda.chatappserver.wwkwkdmg.services;

import com.sda.chatappserver.wwkwkdmg.model.Message;
import com.sda.chatappserver.wwkwkdmg.model.User;
import com.sda.chatappserver.wwkwkdmg.repository.MessageRepository;
import com.sda.chatappserver.wwkwkdmg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImp implements MessageService {

    private MessageRepository messageRepository;
    private UserRepository userRepository;

    @Autowired
    public MessageServiceImp(MessageRepository messageRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
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
