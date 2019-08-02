package com.searchBook.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.searchBook.domain.User;

@RunWith(SpringRunner.class)
// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DataJpaTest
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
        String username = "1234";

        Optional<User> user = this.userRepository.findByUsername(username);
        assertNotNull(user);
    }





    @Test
    public void userRepositoryTest()
    {
        User user = new User();
        user.setUsername("koki");

        User saveUser = this.userRepository.save(user);

        assertThat(saveUser).isNotNull();

        Optional<User> existingUser = this.userRepository.findByUsername(saveUser.getUsername());
        assertThat(existingUser).isNotEmpty();

        Optional<User> emptyUser = this.userRepository.findByUsername("k123");
        assertThat(emptyUser).isEmpty();

    }





    @After
    public void deleteAll()
    {
        this.userRepository.deleteAll();
    }

}
