package com.searchBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.searchBook.service.UserService;

@Controller
public class UserController
{
    @Autowired
    UserService userService;





    @GetMapping("/login")
    public String login()
    {

        return "login";
    }





    @GetMapping("/register")
    public String register(@RequestParam final String username, @RequestParam final String password)
    {
        this.userService.regist(username, password);
        return "register";
    }





    @PostMapping("/checkId")
    public @ResponseBody String checkId(@RequestParam final String username)
    {
        String str = "";
        boolean idcheck = this.userService.existsId(username);
        if ( idcheck == true )
        { // 이미 존재하는 계정
            str = "NO";
        }
        else
        { // 사용 가능한 계정
            str = "YES";
        }
        return "login";
    }
}
