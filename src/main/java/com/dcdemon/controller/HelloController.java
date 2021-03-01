package com.dcdemon.controller;

import com.dcdemon.dto.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RequestMapping("hello")
@RestController
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

    @RequestMapping("/getUser")
    //    @ResponseBody
    public List<User> requestBodyTest(@RequestBody User u) {
        User user1 = User.builder()
                .id(1)
                .name("名")
                .date(new Date())
                .build();
        User user2 = User.builder()
                .id(2)
                .name("名2")
                .date(new Date())
                .build();
        List users = new ArrayList();
        users.add(user1);
        users.add(user2);
        return users;
    }

}
