package com.hznu.web_work.handle;

import com.hznu.web_work.WebWorkApplication;
import com.hznu.web_work.domain.Hello;
import com.hznu.web_work.service.HelloService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebWorkApplication.class})
public class HelloServiceTest
{
    @Autowired
    private HelloService helloService;

    @Test
    public void testHelloList()
    {
        List<Hello> helloList = helloService.listHello();
        TestCase.assertTrue(helloList.size() > 0);
    }
}
