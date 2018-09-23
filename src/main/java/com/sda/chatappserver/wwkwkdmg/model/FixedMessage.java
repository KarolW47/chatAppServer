package com.sda.chatappserver.wwkwkdmg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class FixedMessage {

    private Long id;
    private String sender;
    private Long recipient;
    private String text;
    private String messageDate;
    private MessageStatus messageStatus;


}
