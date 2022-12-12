package com.dokim.younghan_spring_basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class helloController {



    // 5. 정적컨텐츠 : http://localhost:8080/hello-static.html




    // 6. MVC와 템플릿 엔진
    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hellohello~!");
        return "hello";
    }

    @GetMapping("/hello-mvc/{name}") // http://localhost:8080/hello-mvc/dokim
    public String testMvc(@PathVariable("name")  String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("/hello-mvc2") // http://localhost:8080/hello-mvc2/name=dokim
    public String testMvc2(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }




    // 7.1 Retrun String(Not View)
    @GetMapping("/hello-string") // http://localhost:8080/hello-string
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("/hello-string2") // http://localhost:8080/hello-string2 ,  http://localhost:8080/hello-string2?name=dokim
    @ResponseBody
    public String helloString2(@RequestParam(value = "name",required = false) String name){
        return "hello " + name;
    }



    // 7.2 API
    @GetMapping("/hello-api") // http://localhost:8080/hello-api?name=dokim&num=010
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name, @RequestParam("num") int num){
        Hello hello = new Hello();
        hello.setName(name);
        hello.setNum(num);
        return hello;
    }

    static class Hello {
        private String name;

        private int num;

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public String getName() {

            return name;
        }

        public void setName(String name) {

            this.name = name;
        }
    }

}
