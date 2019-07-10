package com.dylan.controller;

import com.dylan.entity.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello() {
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
