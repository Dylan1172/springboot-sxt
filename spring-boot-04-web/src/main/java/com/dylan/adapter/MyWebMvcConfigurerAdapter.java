package com.dylan.adapter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
 *
 * @Author Dylan.W
 * @Date 2019/7/9 23:03
 */
//@EnableWebMvc   //全面接管SpringMVC;所有的SpringMVC的自动配置都失效了
@Configuration  //作为一个配置类
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        //浏览器发送 /hello_world 请求来到 helloWorld
        registry.addViewController("/hello_world").setViewName("helloWorld");
    }
}
