package com.sda.chatappserver.wwkwkdmg.services;

import com.sda.chatappserver.wwkwkdmg.model.User;
import com.sda.chatappserver.wwkwkdmg.model.UserStatus;
import com.sda.chatappserver.wwkwkdmg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUserToDB(User user) {
        user.setStatus(UserStatus.away);
        return userRepository.save(user);
    }

    @Override
    public User getUserFromDb(String login, String password) {
        return userRepository.findUserByNickAndPassword(login, password);
    }
}
