package com.sda.chatappserver.wwkwkdmg.repository;

import com.sda.chatappserver.wwkwkdmg.model.User;
import com.sda.chatappserver.wwkwkdmg.model.UserStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Long> {

    User findUserByNickAndPassword(String nick, String password);

    User findByNick(String nick);

    @Transactional
    @Modifying
    @Query(value = "UPDATE User u set u.status = ?2 where u.id = ?1")
    void updateUserStatusById(Long id, UserStatus status);
}
