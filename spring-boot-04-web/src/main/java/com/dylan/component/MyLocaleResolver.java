package com.dylan.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 区域信息解析器
 * 可以在连接上携带区域信息
 *
 * @Author Dylan.W
 * @Date 2019/7/10 11:12
 */
public class MyLocaleResolver implements LocaleResolver {

    /**
     * 处理请求路径传递过来的参数：msg=zh_CN
     *
     * @param request
     * @return 国际化Locale（区域信息对象）
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        System.out.println("*****区域信息解析器*****");
        String msg = request.getParameter("msg");
        Locale locale = Locale.getDefault();
        if (!StringUtils.isEmpty(msg)) {
            String split[] = msg.split("_");
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
