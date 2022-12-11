package com.dokim.younghan_spring_basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {

    // 5. 정적컨텐츠
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hellohello~!");
        return "hello";
    }


    // 6. MVC와 템플릿 엔진
    @GetMapping("/hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }


    // 7. API
    @GetMapping("/hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
