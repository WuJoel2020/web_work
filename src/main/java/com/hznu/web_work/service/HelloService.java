package com.hznu.web_work.service;

import com.hznu.web_work.domain.Hello;

import java.util.List;

public interface HelloService
{
    List<Hello> listHello();  // 接口里可以定义许多方法，具体实现在Impl里，Controller可以调用接口的方法。
}
