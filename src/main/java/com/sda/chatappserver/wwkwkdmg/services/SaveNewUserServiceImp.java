package com.sda.chatappserver.wwkwkdmg.services;

import com.sda.chatappserver.wwkwkdmg.model.User;
import com.sda.chatappserver.wwkwkdmg.model.UserStatus;
import com.sda.chatappserver.wwkwkdmg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaveNewUserServiceImp implements SaveNewUserService {

    private UserRepository userRepository;

    @Autowired
    public SaveNewUserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUserToDB(User user) {
        user.setStatus(UserStatus.away);
        return userRepository.save(user);
    }
}
