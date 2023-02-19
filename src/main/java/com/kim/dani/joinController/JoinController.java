package com.kim.dani.joinController;


import com.kim.dani.entity.Team;
import com.kim.dani.jwt.JwtTokenProvider;
import com.kim.dani.jwt.JwtTokenValidator;
import com.kim.dani.service.MemberService;
import com.kim.dani.service.MemberV2Service;
import com.kim.dani.service.TeamService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
@RequestMapping("/main")
@RequiredArgsConstructor
public class JoinController {

    private final MemberService memberService;
    private final TeamService teamService;
    private final MemberV2Service memberV2Service;
    private final JwtTokenProvider jwtTokenProvider;



    @GetMapping("/login")
    public String test(HttpServletResponse res){
        return jwtTokenProvider.setTokenCookie(res , "dani");
    }

    @GetMapping("/validation")
    public String test2(HttpServletRequest req){
        JwtTokenValidator jwtTokenValidator = new JwtTokenValidator();
        return jwtTokenValidator.jwtGetUserId(req);
//        Cookie[] cookie = req.getCookies();
//        for (Cookie cookie1 : cookie) {
//            if(cookie1.getName().equals("jwt")){
//                String token = cookie1.getValue();
//                System.out.println(token);
//
//            }
//        }
//
        return "okkk";
    }

//    eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkYW5pIiwiaWF0IjoxNjc2ODA0NzA0LCJleHAiOjE2NzY4MDQ3MDQsImlkIjoiMjMiLCJlbWFpbCI6ImRhbmkifQ.bvnb0v7g0xTjue80zGkDrOxu2QPbuh20SwVdMEbHbYyM6BSgnlKG0F9I9XkyuQAtxTcHsscgiUyOewcNYMhWTw
//    eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkYW5pIiwiaWF0IjoxNjc2ODA0NzExLCJleHAiOjE2NzY4MDQ3MTEsImlkIjoiMjMiLCJlbWFpbCI6ImRhbmkifQ.TwVwBme4ADxjaYFSibYzNLXRQgRJjHufD40XR7hbfO5GUaxJ8ScqHVpbz4AuUWXILh5vw1q2p02zdtRQCgicNQ
//    eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkYW5pIiwiaWF0IjoxNjc2ODA1MDM3LCJleHAiOjE2NzY4MDUwMzcsImlkIjoiMjMiLCJlbWFpbCI6ImRhbmkifQ.82XFcXPCVjRAS8gguMn9bGevICUwF18eR9iVZc0y7P5US5STj2Phk6slxKw_a_khp3p6Dirf5zRfWkfeVmOCMw



    @RequestMapping("/test")
    public Team test2(){
       Team team= teamService.saveTeam();

        return team;
    }

    @RequestMapping("/test2")
    public String test3(){
  memberService.saveMember();

        return "okokopo";
    }

    @RequestMapping("/test3")
    public String test4(){
        memberV2Service.saveMember();
        return "okkookokokokokok";
    }
}
