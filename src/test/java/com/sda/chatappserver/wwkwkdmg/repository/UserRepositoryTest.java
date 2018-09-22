package com.sda.chatappserver.wwkwkdmg.repository;


import com.sda.chatappserver.wwkwkdmg.WwkwkdmgApplicationTests;
import com.sda.chatappserver.wwkwkdmg.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { WwkwkdmgApplicationTests.class })
//@Transactional
//@DirtiesContext
public class UserRepositoryTest  {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DataSource dataSource;


    @Test
    public void should_Find_User_By_Nick_And_Password(){
        User result = userRepository.findUserByNickAndPassword("Bobek", "123");
       // result.getNick();
       // result.getPassword();
        Integer userID = result.getId().intValue();
        //String result2 = result1.toString();

        assertThat(userID, is(10));
    }




        }

