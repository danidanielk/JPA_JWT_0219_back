package com.kim.dani.controller;


import com.kim.dani.jwt.JwtTokenProvider;
import com.kim.dani.jwt.JwtTokenValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
@RequestMapping("/main")
@RequiredArgsConstructor
public class UsersController {


    private final JwtTokenProvider jwtTokenProvider;
    private final JwtTokenValidator jwtTokenValidator;



    @GetMapping("/login")
    public String test(HttpServletResponse res){
        return jwtTokenProvider.setTokenCookie(res , "dani");
    }

    @GetMapping("/validation")
    public String test2(HttpServletRequest req){
        return jwtTokenValidator.jwtGetUserId(req);
    }



}
