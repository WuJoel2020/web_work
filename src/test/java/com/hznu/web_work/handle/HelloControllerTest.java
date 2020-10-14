package com.hznu.web_work.handle;

import com.hznu.web_work.WebWorkApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebWorkApplication.class})
@AutoConfigureMockMvc
public class HelloControllerTest
{
    @Autowired
    private MockMvc mockMvc;  // 实例一个MockMvc对象

    @Test
    public void testHelloListApi() throws Exception
    {
        MvcResult mvcResult;
        mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/hello/list")).andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println(status);
    }
}
