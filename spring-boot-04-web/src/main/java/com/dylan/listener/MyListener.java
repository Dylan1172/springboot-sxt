package com.dylan.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 自定义监听器
 *
 * @Author Dylan.W
 * @Date 2019/7/11 15:06
 */
public class MyListener implements ServletContextListener {

    /**
     * 监听器初始化
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("MyListener contextInitialized ...");
    }

    /**
     * 监听器销毁
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("MyListener contextDestroyed ...");
    }
}
