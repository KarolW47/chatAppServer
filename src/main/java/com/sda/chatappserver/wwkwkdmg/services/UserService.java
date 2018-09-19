package com.sda.chatappserver.wwkwkdmg.services;

import com.sda.chatappserver.wwkwkdmg.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUserToDB(User user);

    User getUserFromDbByLoginAndPassword(String login, String password);

    List<User> getUserListFromDb();

    Optional<User> getUserFromDbByLogin(String nick);

    User getUserFromDbById(Long id);
}
