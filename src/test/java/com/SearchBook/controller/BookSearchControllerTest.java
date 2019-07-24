package com.searchBook.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.Principal;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookSearchControllerTest
{
    private MockMvc mockMvc;





    // @MockBean
    // BookSearchController bookSearchController;

    @Before
    public void setup()
    {
        // this.mockMvc = MockMvcBuilders.standaloneSetup(this.bookSearchController)
        // .build();
    }

    private final String API_URL   = "https://dapi.kakao.com/v3/search/book";

    String               query     = "강남";
    String               sort      = "accuracy";
    int                  page      = 1;
    int                  size      = 5;
    String               target    = "isbn";
    Principal            principal = new Principal();





    // https://blusky10.tistory.com/288 (@pathVariable)

    @Test
    public void getBookTest() throws Exception
    {
        // given(this.bookSearchController.searchBook(this.principal, this.query);
    }





    // https://dapi.kakao.com/v3/search/book?query=%EA%B0%95%EB%82%A8&sort=accuracy&page=1&size=5
    @Test
    public void getURLMakeTest()
    {

        // "query=accuracy

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(this.API_URL)
                                                           .queryParam("query", this.query)
                                                           .queryParam("sort", this.sort)
                                                           .queryParam("page", this.page)
                                                           .queryParam("size", this.size);

        System.out.println(builder.toUriString());

    }
}
