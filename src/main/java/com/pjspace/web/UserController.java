package com.pjspace.web;

import com.pjspace.vo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.web.reactive.context.StandardReactiveWebEnvironment;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @program: chiapterl
 * @description: 用户控制类
 * @author: Mr.Wang
 * @create: 2018-12-31 15:24
 **/

@RestController
@RequestMapping(value = "/users")   // 通过这里配置使下面的映射都在/users下，可去除
public class UserController {

    //创建线程安全的Map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long,User>());

    @ApiOperation(value = "获取用户表",notes = "")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<User> getUserList() {
        //处理"/users/"的GET请求，用来获取用户列表
        //还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递。
        List<User> r = new ArrayList<>(users.values());
        return r;
    }

    @ApiOperation(value = "创建用户表",notes = "")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {

        //处理"/users"的POST请求，用来创建User
        //除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        users.put(user.getId(),user);
        return "success" ;
    }

    @ApiOperation(value = "获取用户的详细信息",notes = "根据url中的id获取")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        //处理"/users/{id}"的GET请求，用来获取url中的id之的User信息
        //url中的id可通过@PathVariable绑定到函数的参数中
        return users.get(id);
    }

    @ApiOperation(value = "更新用户详细信息",notes = "根据ual中的id获取")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String putUser(@PathVariable Long id, @ModelAttribute User user) {
        //处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id,u);
        return "success";
    }

    @ApiOperation(value = "删除用户信息",notes = "根据url的id删除")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable long id) {
        //处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }



}
