package com.searchBook.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.searchBook.domain.UserHistory;
import com.searchBook.service.RequestBookService;
import com.searchBook.service.UserHistoryService;
import com.searchBook.support.Util;
import com.searchBook.vo.response.ResponseVo;

/*
 * query 검색을 원하는 질의어 O String
 * sort 결과 문서 정렬 방식 X (accuracy) accuracy (정확도순) or latest (최신순)
 * page 결과 페이지 번호 X(기본 1) 1-100 사이 Integer
 * size 한 페이지에 보여질 문서의 개수 X(기본 10) 1-50 사이 Integer
 * target 검색 필드 제한 X title (제목에서 검색) or isbn (ISBN에서 검색) or publisher (출판사에서 검색) or person(인명에서 검색)
 */

@Controller
public class BookController
{
    private final String API_URL = "https://dapi.kakao.com/v3/search/book?";

    @Autowired
    RequestBookService   requestBookService;
    @Autowired
    UserHistoryService   userHistoryService;





    @PostMapping("request/search")
    public String SearchRequest(final Principal principal, @RequestParam final String query, @RequestParam final Optional<String> sort, @RequestParam final Optional<Integer> page,
            @RequestParam final Optional<Integer> size, @RequestParam final Optional<String> target, final Model model)

    {
        String currentID = principal.getName();
        String url = Util.makeURL(this.API_URL, query, sort.orElse(null), Integer.toString(page.orElse(1)), Integer.toString(size.orElse(10)), target.orElse(null));

        this.userHistoryService.saveUserHistory(currentID, query);
        ResponseVo responseVo = this.requestBookService.requestData(url);
        model.addAttribute("bookRes", responseVo);

        return "search-book";
    }





    @GetMapping("request/history")
    public @ResponseBody Page<UserHistory> historyRequest(final Principal principal, @RequestParam final Pageable pageable)

    {
        String currentID = principal.getName();
        Page<UserHistory> userHistoryPage = this.userHistoryService.findUserHistory(currentID, pageable);

        return userHistoryPage;
    }

    /*
     * @GetMapping("request/PopularKeyword")
     * public Page<UserHistory> popularKeywordRequest(@RequestParam final Pageable pageable)
     * {
     * Page<UserHistory> userHistoryPage = this.userHistoryService.findUserHistory(currentID, pageable);
     *
     * return userHistoryPage;
     * }
     */

}
