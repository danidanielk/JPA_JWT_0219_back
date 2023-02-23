package com.kim.dani.controller;


import com.kim.dani.dto.BoardUploadDto;
import com.kim.dani.dto.JoinDto;
import com.kim.dani.dto.LoginDto;
import com.kim.dani.entity.Board;
import com.kim.dani.entity.Department;
import com.kim.dani.entity.Member;
import com.kim.dani.entity.Users;
import com.kim.dani.jwt.JwtTokenProvider;
import com.kim.dani.jwt.JwtTokenValidator;
import com.kim.dani.repository.BoardRepository;
import com.kim.dani.repository.MemberRepository;
import com.kim.dani.repository.TestRepository;
import com.kim.dani.repository.UsersRepository;
import com.kim.dani.service.BoardService;
import com.kim.dani.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.FileUploadBase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/main")
@RequiredArgsConstructor
public class UsersController {


    private final JwtTokenProvider jwtTokenProvider;
    private final JwtTokenValidator jwtTokenValidator;
    private final UsersService usersService;
    private final BoardService boardService;
    private final TestRepository testRepository;
    private final MemberRepository memberRepository;

//    @GetMapping("/login")
//    public String test(HttpServletResponse res){
//        return jwtTokenProvider.setTokenCookie(res , "dani");
//    }

    @GetMapping("/validation")
    public String test2(HttpServletRequest req){

        String email = jwtTokenValidator.jwtGetUserEmail(req);
        return email;
    }

    @PostMapping("/join")
    public ResponseEntity join(@Valid @RequestBody JoinDto joinDto) {
        Users user = usersService.join(joinDto);
        if (user != null) {
            return new ResponseEntity(user, HttpStatus.OK);
        }
        return new ResponseEntity("Email 중복 409",HttpStatus.CONFLICT);
//        throw new RuntimeException("Email 중복");
    }

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody LoginDto loginDto,HttpServletResponse res){


        String result = usersService.login(loginDto, res);
        if(result != null){
            return new ResponseEntity(result, HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }




    @GetMapping("/test1")
    public void test1(){
        Department department = new Department();
        Member member = new Member();


        department.setName("seni부서");
        testRepository.save(department);

        member.setName("dani");
        member.setAge(23);
        member.setDepartment(department);
        memberRepository.save(member);


    }

    @GetMapping("/test2")
    public void test2(){
        Department department = testRepository.findById(1L).orElse(null);
        testRepository.delete(department);


    }
    @GetMapping("/test3")
    public void test3(){
        Member member = memberRepository.findById(2L).orElse(null);
        memberRepository.delete(member);
    }





}
