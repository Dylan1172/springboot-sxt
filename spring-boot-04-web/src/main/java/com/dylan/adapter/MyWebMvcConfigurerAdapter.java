package com.dylan.adapter;

import com.dylan.resolver.MyLocaleResolver;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


/**
 * 使用WebMvcConfigurer可以来扩展SpringMVC的功能
 * WebMvcConfigurerAdapter方法过期了,使用WebMvcConfigurer接口
 *
 * @Author Dylan.W
 * @Date 2019/7/9 23:03
 */
//@EnableWebMvc   //全面接管SpringMVC;所有的SpringMVC的自动配置都失效了
@Configuration  //作为一个配置类
public class MyWebMvcConfigurerAdapter implements WebMvcConfigurer {

    /**
     * 配置视图解析方式一
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //浏览器发送 /hello_world 请求来到 helloWorld
        registry.addViewController("/hello_world").setViewName("helloWorld");
    }

    /**
     * 配置视图解析方式二
     * 所有的WebMvcConfigurerAdapter组件都会一起起作用
     */
    @Bean   // 放到容器中去
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index").setViewName("index");
            }
        };
        return webMvcConfigurer;
    }

    /**
     * 国际化注入
     *
     * @return
     */
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 不拦截的请求或页面
        List<String> excludePathList = new ArrayList<String>();
        excludePathList.add("/login");// 登录
        excludePathList.add("/logout");// 登出

        excludePathList.add("/public/**");
        excludePathList.add("/static/**");

        excludePathList.add("/");
        excludePathList.add("/index");
        excludePathList.add("/index.html");
        // '/**' 拦截所有页面,去除不拦截的页面
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                .excludePathPatterns(excludePathList);
    }


    /**
     * 嵌入式的Servlet容器的定制器；来修改Servlet容器的配置
     * 在WebServerFactoryCustomizer接口中使用ConfigurableWebServerFactory对象实现对customize()方法的转换，
     * 从而实现对嵌入式servlet容器的配置。
     * WebServerFactoryCustomizer取代EmbeddedServletContainerCustomizer
     *
     * @return
     */
    @Bean //一定要将这个定制器加入到容器中
    public WebServerFactoryCustomizer webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
//                factory.setPort(8088);
            }
        };
    }
}
