package com.pjspace.web;

/**
 * @program: pj-spring-boot-test
 * @description: 自定义异常
 * @author: Mr.Wang
 * @create: 2019-01-05 00:58
 **/
public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}
