package com.searchBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.searchBook.domain.PopularKeyword;

public interface PopularKeywordRepository extends JpaRepository<PopularKeyword, String>
{

}
