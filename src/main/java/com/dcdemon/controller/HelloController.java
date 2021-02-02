package com.dcdemon.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/test1")
    public String test1(@RequestParam(value = "id", required = true) Integer id,
                        @RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date date) {
        System.out.println("test111");
        System.out.println(id + "," + name);
        System.out.println(date);
        return "view/hello";
    }

    @RequestMapping("/test2")
    public String test2() {
        System.out.println("test222");
        return "success";
    }
}
