package com.sda.chatappserver.wwkwkdmg.repository;


import com.sda.chatappserver.wwkwkdmg.model.User;
import com.sda.chatappserver.wwkwkdmg.model.UserStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	@Test
	public void should_Find_User_By_Nick_And_Password() {
		// Arrange
		String nick = "Bobek";
		String password = "123";

		// Act
		User result = userRepository.findUserByNickAndPassword(nick, password);

		// Assert
		assertThat(result.getId(), is(10l));
		assertThat(result.getNick(), is(nick));
		assertThat(result.getPassword(), is(password));
	}
}

