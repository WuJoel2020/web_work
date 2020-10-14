package com.hznu.web_work.service.impl;

import com.hznu.web_work.domain.User;
import com.hznu.web_work.mapper.UserMapper;
import com.hznu.web_work.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService
{
    private static final Map<String, User> sessionMap = new HashMap<>();

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper)
    {
        this.userMapper = userMapper;
    }

    @Override
    public String login(String username, String pwd)
    {
        User user = userMapper.login(username, pwd);  // 调用UserMapper里的login方法，如果返回为空，表示密码或用户名错误
        if (user == null)
        {
            return null;
        }
        else
        {
            String token = UUID.randomUUID().toString();  // 随机生成一个token序列
            System.out.println(token);
            sessionMap.put(token, user);
            return token;
        }
    }
}
