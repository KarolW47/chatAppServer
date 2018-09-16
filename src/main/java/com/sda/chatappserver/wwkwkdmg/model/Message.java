package com.sda.chatappserver.wwkwkdmg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @NonNull
    @Column(name = "sender")
    private Long sender;

    @Column(name = "recipient")
    private Long recipient;

    @NonNull
    @Column(name = "message_text")
    private String text;

    @NonNull
    @Column(name = "message_date")
    private LocalDateTime messageDate;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "message_status")
    private MessageStatus messageStatus;

}
