package com.hznu.web_work.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

// 自定义全局异常返回界面
@ControllerAdvice
public class UserExHandler
{
    @ExceptionHandler(value = ArithmeticException.class)
    // object表示Return返回一个对象
    Object handlerException(ArithmeticException e, HttpServletRequest request)
    {
        // ModelAndView类用来存储处理完后的结果数据，以及显示该数据的视图
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("msg", e.getMessage());
        return modelAndView;
    }
}
