package com.searchBook.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.searchBook.domain.UserHistory;

public interface UserHistoryService
{
    public void saveUserHistory(final String userName, final String query);





    public Page<UserHistory> findUserHistory(final String userName, Pageable pageable);
}
