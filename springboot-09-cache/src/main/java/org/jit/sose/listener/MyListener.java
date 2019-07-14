package org.jit.sose.listener;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 自定义监听器
 *
 * @Author Dylan.W
 * @Date 2019/7/11 15:06
 */
@Slf4j
public class MyListener implements ServletContextListener {

    /**
     * 监听器初始化
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.trace("*****************MyListener contextInitialized*****************");
    }

    /**
     * 监听器销毁
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.trace("*****************MyListener contextDestroyed*****************");
    }
}
