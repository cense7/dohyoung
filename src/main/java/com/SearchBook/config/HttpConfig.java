package com.searchBook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpConfig
{
    private final String APPKEY = "KakaoAK f808b329f4a2e1f51b511f3c80821827";





    @Bean
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }





    @Bean
    public HttpHeaders httpHeaders()
    {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        httpHeaders.add("Authorization", this.APPKEY);
        return httpHeaders;
    }
}
