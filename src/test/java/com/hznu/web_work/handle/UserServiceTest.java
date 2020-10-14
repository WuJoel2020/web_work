package com.hznu.web_work.handle;

import com.hznu.web_work.WebWorkApplication;
import com.hznu.web_work.service.UserService;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WebWorkApplication.class})
public class UserServiceTest
{
    @Autowired
    private UserService userService;

    String nameRight = "xc";
    String passRight = "1234";
    String passWrong = "123";

    @Test
    public void testFail()  // 反测试
    {
        String ans = userService.login(nameRight, passRight);
        TestCase.assertNull(ans);  // 判断是否为空
    }

    @Test
    public void testSuccess()  // 正测试
    {
        String ans = userService.login(nameRight, passWrong);
        TestCase.assertNotNull(ans);
    }

}
