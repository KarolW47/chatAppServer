package com.sda.chatappserver.wwkwkdmg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "nick")
    private String nick;

    @Column(name = "status")
    private UserStatus status;

    @Column(name = "status_txt")
    private String statusTxt;

    @Column(name = "email")
    private String email;
}
