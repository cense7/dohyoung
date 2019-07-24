package com.searchBook.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.searchBook.support.Util;
import com.searchBook.vo.RequestSampleData;

public class UtilityTest
{
    private final String API_URL = "https://dapi.kakao.com/v3/search/book";





    @Test
    public void getURLMakeTest()
    {

        RequestSampleData requestDataTest = new RequestSampleData();

        String url = Util.makeURL(this.API_URL,
                                  requestDataTest.getQuery(),
                                  requestDataTest.getSort(),
                                  Integer.toString(requestDataTest.getPage()),
                                  Integer.toString(requestDataTest.getSize()),
                                  requestDataTest.getTarget());

        System.out.print(url);
        // https://dapi.kakao.com/v3/search/book?query=%EA%B0%95%EB%82%A8&sort=accuracy&page=1&size=5&target=isbn
        String expectedURL = "https://dapi.kakao.com/v3/search/book?query=강남&sort=accuracy&page=1&size=5&target=isbn";
        assertEquals(expectedURL, url);

    }
}
