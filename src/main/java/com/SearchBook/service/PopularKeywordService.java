package com.searchBook.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.searchBook.domain.PopularKeyword;

public interface PopularKeywordService
{
    public List<PopularKeyword> findPopularKeyword(final Page pageable);





    public void savePopularKeyword(final String query);
}
