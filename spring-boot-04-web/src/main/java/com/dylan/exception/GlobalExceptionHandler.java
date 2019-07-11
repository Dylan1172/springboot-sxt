package com.dylan.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局捕获异常
 *
 * @Author Dylan.W
 * @Date 2019/7/11 10:15
 */
@Slf4j
@ControllerAdvice(basePackages = "com.dylan.controller") // 作为全局异常处理的切面类，可以设置包的范围
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     * 视图跳转，不需要@ResponseBody
     *
     * @param e       自定义异常
     * @param request 请求
     * @return 视图跳转
     */
    @ExceptionHandler(MyException.class)
    public String handleException(Exception e, HttpServletRequest request) {
        System.out.println("*****自定义异常捕捉****");
        e.printStackTrace();
        //传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
        request.setAttribute("javax.servlet.error.status_code", 401);
        // 重定向
//        return "redirect:/error";
        //转发到/error
        return "forward:/error";
    }

}
