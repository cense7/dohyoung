package com.searchBook.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.searchBook.domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserRepositoryTest
{

    @Autowired
    private UserRepository userRepository;





    @Test
    public void findAll()
    {
        List<User> userList = this.userRepository.findAll();
        assertThat(userList.size()).isEqualTo(1);
    }





    @Test
    public void findByUsername()
    {
        String username = "kakaoBank";

        Optional<User> user = this.userRepository.findById(username);
        assertNotNull(user);
    }





    @Test
    public void userRepositoryTest()
    {
        User user = new User();
        user.setUsername("bank");
        user.setPassword("123");

        this.userRepository.save(user);

        List<User> userList = this.userRepository.findAll();

        User bank = userList.get(0);
        assertEquals(bank.getUsername(), "bank");
        assertEquals(bank.getPassword(), "123");
    }





    @After
    public void deleteAll()
    {
        this.userRepository.deleteAll();
    }

}
