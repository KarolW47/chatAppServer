package com.sda.chatappserver.wwkwkdmg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor

public class FixedMessage {

    private Long id;
    private String sender;
    private Long recipient;
    private String text;
    private LocalDateTime messageDate;
    private MessageStatus messageStatus;


}
