package com.searchBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.searchBook.domain.UserHistory;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Long>
{

}
