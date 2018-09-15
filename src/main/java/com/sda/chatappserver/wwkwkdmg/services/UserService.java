package com.sda.chatappserver.wwkwkdmg.services;

import com.sda.chatappserver.wwkwkdmg.model.User;

public interface UserService {
    User saveUserToDB(User user);

    User getUserFromDb(String login, String password);

}
