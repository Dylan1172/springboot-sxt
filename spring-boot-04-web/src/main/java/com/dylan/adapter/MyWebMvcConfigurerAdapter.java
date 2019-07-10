package com.dylan.adapter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * 使用WebMvcConfigurer可以来扩展SpringMVC的功能
 * WebMvcConfigurerAdapter方法过期了,使用WebMvcConfigurer接口
 *
 * @Author Dylan.W
 * @Date 2019/7/9 23:03
 */
@EnableWebMvc   //全面接管SpringMVC;所有的SpringMVC的自动配置都失效了
@Configuration  //作为一个配置类
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {

    // 方式一
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /hello_world 请求来到 helloWorld
        registry.addViewController("/hello_world").setViewName("helloWorld");
    }

    // 方式二
    // 所有的WebMvcConfigurerAdapter组件都会一起起作用
    @Bean   // 放到容器中去
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/login").setViewName("index");
            }
        };
        return webMvcConfigurer;
    }

}
