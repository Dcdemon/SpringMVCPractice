package com.dcdemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/test1")
    public String test1() {
        System.out.println("test111");
        return "success";
    }

    @RequestMapping("/test2")
    public String test2() {
        System.out.println("test222");
        return "success";
    }
}
