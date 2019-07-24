package com.searchBook.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.searchBook.domain.PopularKeyword;
import com.searchBook.repository.PopularKeywordRepository;
import com.searchBook.service.PopularKeywordService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PopularKeywordServiceImple implements PopularKeywordService
{
    @Autowired
    PopularKeywordRepository popularKeywordRepository;





    @Override
    public List<PopularKeyword> findPopularKeyword(final Page pageable)
    {
        List<PopularKeyword> popularKeyword = this.popularKeywordRepository.findAll(Sort.by(Order.desc("count")));
        return popularKeyword;
    }





    @Transactional
    @Override
    public void savePopularKeyword(final String query)
    {
        Optional<PopularKeyword> popularKeyword = this.popularKeywordRepository.findById("query");

        if ( popularKeyword.isPresent() )
        {
            long count = popularKeyword.get()
                                       .getCount();

            PopularKeyword popularKeywordUpdate = new PopularKeyword();
            popularKeywordUpdate.setQuery(query);
            popularKeywordUpdate.setCount(count);
            this.popularKeywordRepository.save(popularKeywordUpdate);
        }
        else
        {
            PopularKeyword popularKeywordInsert = new PopularKeyword();
            popularKeywordInsert.setQuery(query);
            popularKeywordInsert.setCount(1);
            this.popularKeywordRepository.save(popularKeywordInsert);
        }
    }

}
