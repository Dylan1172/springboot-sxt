package com.dylan.controller;

import com.dylan.entity.User;
import com.dylan.exception.MyException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    @GetMapping(value = "/hello") // 正常请求
//    @PostMapping(value = "/hello") // 模拟400错误
    public String hello(@RequestParam(value = "name", required = false) String name) {
        if ("ex".equals(name)) {
            // 模拟自定义异常
            throw new MyException();
        } else if ("500".equals(name)) {
            // 模拟500错误
            System.out.println(1 / 0);
        }
        return "Hello,Spring Boot!";
    }

    /**
     * 模拟登录
     *
     * @param userName
     * @param password
     * @param session
     * @return
     */
    @PostMapping(value = "login")
    public String login(@RequestParam(value = "userName", required = true) String userName,
                        @RequestParam(value = "password", required = true) String password,
                        HttpSession session) {
        if ("Dylan.W".equals(userName) && "123456".equals(password)) {
            User user = new User(userName, password);
            session.setAttribute("user", user);
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 清除登录信息
     *
     * @param session
     */
    @GetMapping("/logout")
    public void logout(HttpSession session) {
        session.removeAttribute("user");
    }

}
