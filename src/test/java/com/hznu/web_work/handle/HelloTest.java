package com.hznu.web_work.handle;

import com.hznu.web_work.WebWorkApplication;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebWorkApplication.class})
public class HelloTest
{
    // 在测试前执行
    @Before
    public void testOne()
    {
        System.out.println("before");
    }

    @Test
    public void testTwo()
    {
        System.out.println("test");
        TestCase.assertEquals(1, 1);
    }

    // 在测试后执行
    @After
    public void testThree()
    {
        System.out.println("after");
    }
}
