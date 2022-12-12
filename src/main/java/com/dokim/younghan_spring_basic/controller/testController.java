package com.dokim.younghan_spring_basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {



    // 기본 페이지 설정 2 ( 기본 페이지 설정 1 : index.html)
    @GetMapping
    public String testBasic(){
        return "testBasic";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "ResponseBody test";
    }

    // 정적 페이지
    @GetMapping("/test-static")
    public String testStatic(){
        return "testStatic";
    }

    //동적페이지, 템플릿 MVC
    @GetMapping("/test-mvc/{name}")
    public String testMvc(){

        return "testMvc";
    }



}
