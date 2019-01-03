package com.pjspace.vo;

/**
 * @program: chiapterl
 * @description: 用户
 * @author: Mr.Wang
 * @create: 2018-12-31 15:22
 **/
public class User {
    private Long id;
    private String name;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
