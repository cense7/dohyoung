package com.searchBook.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.Charset;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookControllerTest
{
    private final String    API_URL     = "https://dapi.kakao.com/v3/search/book";

    String                  query       = "강남";
    String                  sort        = "accuracy";
    int                     page        = 1;
    int                     size        = 5;
    String                  target      = "isbn";

    @Autowired
    BookController          bookController;

    private MockMvc         mockMvc;

    private final MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));





    @Before
    public void setUp() throws Exception
    {
        this.mockMvc = MockMvcBuilders.standaloneSetup(this.bookController)
                                      .build();
    }





    @Test
    @WithMockUser(username = "1234")
    public void bookookControllerTest() throws Exception
    {
        // search check
        this.mockMvc.perform(get("/search").param("query", this.query)
                                           .param("sort", this.sort))
                    .andExpect(status().isOk());

        // 비밀번호 찾기 확인
        System.out.println(this.mockMvc.perform(post("/login").param("1235", "12300"))
                                       .andDo(print()));

        /*
         * ObjectMapper mapper = new ObjectMapper();
         * this.mockMvc.perform(post(UserController.URL_USER_CREATE)
         * .contentType(contentType)
         * .content(mapper.writeValueAsString(new User("wedul"))))
         * .andExpect(status().isOk())
         * .andDo(print());
         */
    }

}
