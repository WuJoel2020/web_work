package com.hznu.web_work.handle;

import com.hznu.web_work.utils.JsonData;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

// 普通全局异常捕获
// @RestControllerAdvice
public class ServiceExHandler {
    @ExceptionHandler(value=Exception.class)
    JsonData handlerException(Exception e, HttpServletRequest request){
        return JsonData.buildError("服务端异常出错");
    }
}