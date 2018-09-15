package com.sda.chatappserver.wwkwkdmg.repository;

import com.sda.chatappserver.wwkwkdmg.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByNickAndPassword(String nick, String password);
}
