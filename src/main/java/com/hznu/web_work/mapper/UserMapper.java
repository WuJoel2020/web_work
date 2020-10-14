package com.hznu.web_work.mapper;

import com.hznu.web_work.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserMapper
{
    private static final Map<String, User> userMap = new HashMap<>();

    static
    {
        userMap.put("xc", new User(1, "xc", "123"));
        userMap.put("vivi", new User(1, "vivi", "321"));
    }

    public User login(String username, String pwd)
    {
        User user = userMap.get(username);
        if (user == null)
        {
            return null;
        }
        if (user.getPwd().equals(pwd))
        {
            System.out.println(user.toString());
            return user;
        }
        return null;
    }
}
