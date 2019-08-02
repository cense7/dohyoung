package com.searchBook.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.searchBook.domain.User;

public interface UserRepository extends JpaRepository<User, Long>
{

    // @Query(nativeQuery = true,
    // value = "select * from User where username")
    // User findByUsername(String username);

    Optional<User> findByUsername(String username);

}
