package com.pjspace.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: pj-spring-boot-test
 * @description: Userxml类
 * @author: Mr.Wang
 * @create: 2019-01-05 22:51
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@JacksonXmlRootElement(localName = "UserXml")
public class UserXml {

    @JacksonXmlProperty(localName = "name")
    private String name;
    @JacksonXmlProperty(localName = "age")
    private Integer age;

}
