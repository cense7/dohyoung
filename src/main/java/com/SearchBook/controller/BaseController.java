package com.searchBook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController
{
    @GetMapping("/main")
    public String root()
    {
        return "main";
    }
}
