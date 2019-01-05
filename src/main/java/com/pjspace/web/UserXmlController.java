package com.pjspace.web;

import com.pjspace.xml.UserXml;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: pj-spring-boot-test
 * @description: UserXmlController类
 * @author: Mr.Wang
 * @create: 2019-01-05 22:59
 **/
@Controller
public class UserXmlController {

    @PostMapping(value = "/user",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public UserXml create(@RequestBody UserXml userXml) {
        userXml.setName("test:" + userXml.getName());
        userXml.setAge(userXml.getAge() + 100);
        return userXml;
    }
}
