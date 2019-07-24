package com.searchBook.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.searchBook.domain.UserHistory;
import com.searchBook.repository.UserHistoryRepository;
import com.searchBook.service.UserHistoryService;

@Service
public class UserHistoryServiceImpl implements UserHistoryService
{
    @Autowired
    private UserHistoryRepository userHistoryRepository;





    @Override
    public void saveUserHistory(final String userName, final String query)
    {

        UserHistory userHistory = new UserHistory();

        userHistory.setUsername(userName);
        userHistory.setKeyword(query);

        this.userHistoryRepository.save(userHistory);
    }





    @Override
    public Page<UserHistory> findUserHistory(final String userName, final Pageable pageable)
    {

        UserHistory userHistory = new UserHistory();
        userHistory.setUsername(userName);
        Page<UserHistory> historyList = this.userHistoryRepository.findAll(Example.of(userHistory), pageable);

        return historyList;
    }

}
