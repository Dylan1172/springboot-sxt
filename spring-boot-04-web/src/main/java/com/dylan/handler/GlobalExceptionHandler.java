package com.dylan.handler;

import com.dylan.exception.MyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常
 *
 * @author: Dylan.W
 * @date: 2019年4月4日 下午11:08:20
 */
@Slf4j
@ControllerAdvice(basePackages = "com.dylan.controller") // 作为全局异常处理的切面类，可以设置包的范围
@ResponseBody
public class GlobalExceptionHandler {


    @ExceptionHandler(MyException.class)
    public Map<String, Object> handleException(Exception e, HttpServletRequest request) {
        System.out.println("*****自定义异常捕捉****");
        Map<String, Object> map = new HashMap<>();
        //传入我们自己的错误状态码  4xx 5xx，否则就不会进入定制错误页面的解析流程
        request.setAttribute("javax.servlet.error.status_code", 401);
        map.put("code", 400);
        map.put("message", e.getMessage());
        return map;
    }


}
