package com.sda.chatappserver.wwkwkdmg.services;

import com.sda.chatappserver.wwkwkdmg.model.User;
import com.sda.chatappserver.wwkwkdmg.model.UserStatus;
import com.sda.chatappserver.wwkwkdmg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImp() {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUserToDB(User user) {
        user.setStatus(UserStatus.away);
        user.setLogStatus(false);
        return userRepository.save(user);
    }

    @Override
    public User getUserFromDbByLoginAndPassword(String login, String password) {
        return userRepository.findUserByNickAndPassword(login, password);
    }

    @Override
    public List<User> getUserListFromDb() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(usr -> users.add(usr));
        return users;
    }

    @Override
    public Optional<User> getUserFromDbByLogin(String nick) {
        return Optional.ofNullable(userRepository.findByNick(nick));
    }

    @Override
    public User getUserFromDbById(Long id) {
        return userRepository.findById(id).get();
    }

    public User getUserFromDb(String nick, String password) {
        return userRepository.findUserByNickAndPassword(nick, password);

    }
}
