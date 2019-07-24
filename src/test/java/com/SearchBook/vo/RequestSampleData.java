package com.searchBook.vo;

import lombok.Getter;
import lombok.Setter;

/*
 * query 검색을 원하는 질의어 O String
 * sort 결과 문서 정렬 방식 X (accuracy) accuracy (정확도순) or latest (최신순)
 * page 결과 페이지 번호 X(기본 1) 1-100 사이 Integer
 * size 한 페이지에 보여질 문서의 개수 X(기본 10) 1-50 사이 Integer
 * target 검색 필드 제한 X title (제목에서 검색) or isbn (ISBN에서 검색) or publisher (출판사에서 검색) or person(인명에서 검색)
 */

@Getter
@Setter

public class RequestSampleData
{

    private final String query;
    private final String sort;
    private final int    page;
    private final int    size;
    private final String target;





    public RequestSampleData()
    {
        this.query = "강남";
        this.sort = "accuracy";
        this.page = 1;
        this.size = 5;
        this.target = "isbn";

    }

}
