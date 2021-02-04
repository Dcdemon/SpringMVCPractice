package com.dcdemon.controller;

import com.dcdemon.dto.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
@RequestMapping("hello")
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
    public String test2(User user) {
        System.out.println("哈哈");
        return "view/hello";
    }

    /**
     * 重定向跳转测试
     *
     * @param user
     * @return
     */
    @RequestMapping("/redirectTest")
    public String test3(User user) {
        //绝对路径
        //return "redirect:/hello/test2";
        //相对路径
        return "redirect:test2";
    }

    /**
     * 转发跳转测试
     *
     * @param user
     * @return
     */
    @RequestMapping("/forwardTest")
    public String test4(User user) {
        return "forward:test2";
    }

    /**
     * @return
     */
    @RequestMapping("/registUser")
    public String registUser() {
        System.out.println("注册用户");
        return "redirect:/index.jsp";
    }

}
