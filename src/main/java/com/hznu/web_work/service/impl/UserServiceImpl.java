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
        User user = userMapper.login(username, pwd);
        if (user == null)
        {
            return null;
        }
        else
        {
            String token = UUID.randomUUID().toString();
            System.out.println(token);
            sessionMap.put(token, user);
            return token;
        }
    }
}
