package com.dylan.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器
 *
 * @Author Dylan.W
 * @Date 2019/7/11 14:54
 */
public class MyFilter implements Filter {

    /**
     * 用于完成Filter的初始化
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 实现过滤功能，该方法就是对每个请求及响应增加的额外处理。<br>
     * 该方法可以实现对用户请求进行预处理(ServletRequest request)，<br>
     * 也可实现对服务器响应进行后处理(ServletResponse response)；<br>
     * 它们的分界线为是否调用了filterChain.doFilter()，<br>
     * 执行该方法之前，即对用户请求进行预处理，<br>
     * 执行该方法之后，即对服务器响应进行后处理。<br>
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do MyFilter...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    /**
     * 用于Filter销毁前，完成某些资源的回收
     */
    @Override
    public void destroy() {

    }
}
