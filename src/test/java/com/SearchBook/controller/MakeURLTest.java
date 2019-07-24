package com.searchBook.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MakeURLTest
{

    private final String API_URL = "https://dapi.kakao.com/v3/search/book";

    String               query   = "강남";
    String               sort    = "accuracy";
    int                  page    = 1;
    int                  size    = 5;
    String               target  = "isbn";





    // https://dapi.kakao.com/v3/search/book?query=%EA%B0%95%EB%82%A8&sort=accuracy&page=1&size=5&target=isbn
    @Test
    public void getURLMakeTest()
    {

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.API_URL)
                                                           .queryParam("query", this.query)
                                                           .queryParam("sort", this.sort)
                                                           .queryParam("page", this.page)
                                                           .queryParam("size", this.size)
                                                           .queryParam("target", this.target);

        String expectedURL = "https://dapi.kakao.com/v3/search/book?query=%EA%B0%95%EB%82%A8&sort=accuracy&page=1&size=5&target=isbn";
        assertEquals(expectedURL, builder.toUriString());

    }
}
