package com.hznu.web_work.service.impl;

import com.hznu.web_work.domain.Hello;
import com.hznu.web_work.mapper.HelloMapper;
import com.hznu.web_work.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelloServiceImpl implements HelloService
{
    // 这里使用set方法注入，而不是变量注入
    private HelloMapper helloMapper;

    @Autowired
    public void setHelloMapper(HelloMapper helloMapper)
    {
        this.helloMapper = helloMapper;  // 使用this来代指HelloServiceImpl类。
    }

    // 实现listHello()方法，通过注入了一个helloMapper类，然后调用里面的listHello()方法。
    @Override
    public List<Hello> listHello()
    {
        return helloMapper.listHello();
    }
}
