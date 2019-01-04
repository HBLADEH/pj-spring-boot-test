package com.pjspace.web;

/**
 * @program: pj-spring-boot-test
 * @description: 统一异常返回JSON格式
 * @author: Mr.Wang
 * @create: 2019-01-05 00:53
 **/
public class ErrorInfo<T> {
    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;

    private T data;

    private String message;
    private String url;

    public void setCode(Integer code) {
        this.code = code;
    }
    public Integer getCode() {
        return code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }

    public void setData(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }

}
