package com.pjspace.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: chiapterl
 * @description: 测试类
 * @author: Mr.Wang
 * @create: 2018-12-29 14:28
 **/
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(ModelMap map) {
        //加入一个属性，用来在模板读取
        map.addAttribute("host","http://blog.didispace.com");

        return "index";
    }

}
