package com.pjspace;

import com.pjspace.web.UserController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import sun.security.x509.DeltaCRLIndicatorExtension;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @program: chiapterl
 * @description: 应用测试类
 * @author: Mr.Wang
 * @create: 2018-12-31 15:48
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MockServletContext.class)
@WebAppConfiguration
public class ApplicationTest {
    private MockMvc mvc;

    @Before
    public void setUpp() throws Exception{
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserContorller() throws Exception{
        //测试UserContorller
        RequestBuilder requestBuilder = null;

        //1.get查一下user列表,应该为空
        requestBuilder = get("/users/");
        mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        //2.post提交一个user
        requestBuilder = post("/users/")
                .param("id","1")
                .param("name","BLADE")
                .param("age","20");
        mvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("success")));

        //3.get获取user列表,此时应有刚才输入的数据
        requestBuilder = get("/users/");
        mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"id\":1,\"name\":\"BLADE\",\"age\":20}]")));

        //4.put修改id为1的user
        requestBuilder = put("/users/1")
                .param("name","HBLADEH")
                .param("age","30");
        mvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("success")));

        //5.get一个id为1的user
        requestBuilder = get("/users/1");
        mvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"HBLADEH\",\"age\":30}")));

        //6.del删除id为1的user
        requestBuilder = delete("/users/1");
        mvc.perform(requestBuilder)
                .andExpect(content().string(equalTo("success")));

        //7.get查user,此时应为空
        requestBuilder = get("/users/");
        mvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }



}
