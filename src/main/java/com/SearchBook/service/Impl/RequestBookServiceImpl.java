package com.searchBook.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.searchBook.service.RequestBookService;
import com.searchBook.vo.response.ResponseVo;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RequestBookServiceImpl implements RequestBookService
{
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private HttpHeaders  headers;





    @Override
    public ResponseVo requestData(final String url)
    {
        ResponseEntity<ResponseVo> response = this.restTemplate.exchange(url, HttpMethod.GET, new HttpEntity<>(this.headers), ResponseVo.class);
        return (response.getStatusCode() == HttpStatus.OK) ? response.getBody() : null;
    }

}
