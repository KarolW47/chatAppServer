package com.sda.chatappserver.wwkwkdmg.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

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

    @NonNull
    @Column(name = "nick", unique = true)
    private String nick;

    @NonNull
    @Column(name = "password")
    private String password;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "status")
    private UserStatus status;

    @Column(name = "status_txt")
    private String statusTxt;

    @NonNull
    @Column(name = "email")
    private String email;

    @NonNull
    @Column(name = "log_status")
    private boolean logStatus;
}
