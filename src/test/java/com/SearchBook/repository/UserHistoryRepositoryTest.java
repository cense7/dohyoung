package com.searchBook.repository;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.searchBook.domain.UserHistory;
import com.searchBook.support.Util;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserHistoryRepositoryTest
{
    @Autowired
    private UserHistoryRepository userHistoryRepository;





    @Test
    public void userHistoryFindByUsernameAndSizeComppareTest()
    {

        for ( int i = 0; i < 10; i++ )
        {
            UserHistory userHistory = new UserHistory();
            userHistory.setUsername("bank");
            userHistory.setKeyword(Util.makeRandomString());
            this.userHistoryRepository.save(userHistory);
        }

        for ( int i = 0; i < 3; i++ )
        {
            UserHistory userHistory = new UserHistory();
            userHistory.setUsername("user");
            userHistory.setKeyword(Util.makeRandomString());
            this.userHistoryRepository.save(userHistory);
        }

        UserHistory bankHistory = new UserHistory();
        bankHistory.setUsername("bank");
        // Page<UserHistory> historyList = this.userHistoryRepository.findAll(Example.of(userHistory), pageable);
        PageRequest page1 = PageRequest.of(1, 10, Sort.by(Order.asc("searchtime")));
        Page<UserHistory> bankHistoryPage = this.userHistoryRepository.findAll(Example.of(bankHistory), page1);
        assertEquals(bankHistoryPage.getSize(), 10);

        PageRequest page2 = PageRequest.of(1, 3, Sort.by(Order.asc("searchtime")));
        Page<UserHistory> userHistoryPage = this.userHistoryRepository.findAll(Example.of(bankHistory), page2);
        assertEquals(userHistoryPage.getSize(), 3);

    }





    @After
    public void deleteAll()
    {
        this.userHistoryRepository.deleteAll();
    }
}
