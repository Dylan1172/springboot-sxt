package com.dylan.exception;

/**
 * 自定义异常
 *
 * @author: Dylan.W
 * @create: 2019-07-10 23:43:36
 */
public class MyException extends RuntimeException {

    public MyException() {
        super("自定义异常");
    }

}

