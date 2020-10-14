package com.hznu.web_work.controller;

import com.hznu.web_work.domain.User;
import com.hznu.web_work.service.UserService;
import com.hznu.web_work.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController
{
    private UserService userService;
    @Autowired
    public void setUserService(UserService userService){
        this.userService = userService;
    }

    @PostMapping("login")
    public JsonData login(@RequestBody User user){
        String token = userService.login(user.getUsername(),user.getPwd());  // 调用userService接口的login方法
        return token !=null ?JsonData.buildSuccess(token):JsonData.buildError("账号密码错误");
    }
}
