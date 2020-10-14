package com.hznu.web_work.controller;

import com.hznu.web_work.domain.Hello;
import com.hznu.web_work.service.HelloService;
import com.hznu.web_work.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hello")
public class HelloController
{
    private HelloService helloService;

    @Autowired
    public void setHelloService(HelloService helloService)
    {
        this.helloService = helloService;
    }

    @GetMapping("list")
    public JsonData List()
    {
        List<Hello> list = helloService.listHello();
        return JsonData.buildSuccess(list);
    }
}
