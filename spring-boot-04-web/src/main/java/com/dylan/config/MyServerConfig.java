package com.dylan.config;

import com.dylan.filter.MyFilter;
import com.dylan.listener.MyListener;
import com.dylan.servlet.MyServlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * 由于SpringBoot默认是以jar包的方式启动嵌入式的Servlet容器来启动SpringBoot的web应用，没有web.xml文件。
 * 注册三大组件用以下方式
 *
 * @Author Dylan.W
 * @Date 2019/7/11 14:26
 */
@Configuration
public class MyServerConfig {

    /**
     * 将Servlet注册进容器中
     *
     * @return
     */
    @Bean
    public ServletRegistrationBean myServlet() {
        // 构造方法
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new MyServlet(), "/myServlet");
//        servletRegistrationBean.setServlet(new MyServlet());
        return servletRegistrationBean;
    }

    /**
     * 将Filter注册进容器中
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        // 设置拦截器
        filterRegistrationBean.setFilter(new MyFilter());
        // 拦截的路径
        List<String> urlList = Arrays.asList("/hello", "/myServlet");
        filterRegistrationBean.setUrlPatterns(urlList);
        return filterRegistrationBean;
    }

    /**
     * 将Listener注册进容器中
     *
     * @return
     */
    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean<MyListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return servletListenerRegistrationBean;
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
//                factory.setPort(8088); // 修改端口
            }
        };
    }

}
