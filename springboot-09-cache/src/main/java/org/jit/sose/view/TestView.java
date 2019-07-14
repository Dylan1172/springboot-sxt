package org.jit.sose.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 模块视图跳转
 * 注意：
 * 1、请求路径唯一，切勿与其他任何请求路径重复<br>
 * 2、请求返回的视图，切勿与其他任何请求路径重复<br>
 *
 * @author: Dylan.W
 * @date: 2019年4月18日 下午11:15:01
 */
@Controller
public class TestView {

    @GetMapping("hello_world")
    public String test() {
        return "helloWorld";
    }

}
