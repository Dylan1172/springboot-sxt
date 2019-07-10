package com.dylan.interceptor;

import com.dylan.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 *
 * @Author Dylan.W
 * @Date 2019/7/10 14:42
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {

    /**
     * 该方法将在请求处理之前进行调用
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("*****登录拦截器*****");
        // 获取session中的user
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            request.setAttribute("msg", "请先登录");
            // 转发
//            request.getRequestDispatcher("/index").forward(request, response);
            // 重定向到登录页面
            response.sendRedirect("index");
            return false;
        }
        return true;
    }

    /**
     * 需要当前对应的Interceptor 的preHandle 方法的返回值为true 时才会执行<br>
     * 在当前请求进行处理之后，也就是Controller 方法调用之后执行，但是它会在DispatcherServlet 进行视图返回渲染之前被调用<br>
     * 所以我们可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 需要当前对应的Interceptor 的preHandle 方法的返回值为true 时才会执行<br>
     * 该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。<br>
     * 这个方法的主要作用是用于进行资源清理工作的。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
