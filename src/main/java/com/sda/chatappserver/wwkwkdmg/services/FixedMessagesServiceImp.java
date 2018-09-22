package com.sda.chatappserver.wwkwkdmg.services;

import com.sda.chatappserver.wwkwkdmg.model.FixedMessage;
import com.sda.chatappserver.wwkwkdmg.model.Message;
import com.sda.chatappserver.wwkwkdmg.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FixedMessagesServiceImp implements FixedMessageService {

    private UserService userService;
    private MessageService messageService;

    @Autowired
    public FixedMessagesServiceImp(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @Override
    public List<FixedMessage> getFixedMessages() {
        List<Message> messageList = messageService.getAllMessages();
        List<User> userList = userService.getUserListFromDb();
        List<FixedMessage> fixedMessages = new ArrayList<>();
        for (int j = 0; j < messageList.size(); j++) {
            for (int i = 0; i < userList.size(); i++) {
                if (messageList.get(j).getSender().equals(userList.get(i).getId())) {
                    String userTakenFromMessage = userList.get(i).getNick();

                    fixedMessages.add(new FixedMessage(messageList.get(j).getId(),
                            userTakenFromMessage,
                            messageList.get(j).getRecipient(),
                            messageList.get(j).getText(),
                            messageList.get(j).getMessageDate(),
                            messageList.get(j).getMessageStatus()));
                }
            }
        }
        return fixedMessages;
    }
}
