package com.searchBook.controller;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookRestControllerTest1
{
    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int              port;





    @Test
    public void getHello() throws Exception
    {

        ResponseEntity<String> response = this.restTemplate.getForEntity(new URL("http://localhost:" + this.port + "/login").toString(), String.class);
        assertEquals("Hello Controller", response.getBody());

    }
}
