package com.searchBook.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class PasswordTest
{
    private PasswordEncoder passwordEncoder;





    @Before
    public void setUp() throws Exception
    {
        this.passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }





    @Test
    public void encode()
    {
        String password = "12300";
        String encPassword = this.passwordEncoder.encode(password);
        System.out.println(encPassword);
        assertTrue(this.passwordEncoder.matches(password, encPassword));
        assertThat(encPassword).contains("{bcrypt}");
    }

}
